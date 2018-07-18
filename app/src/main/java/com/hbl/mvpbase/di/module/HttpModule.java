package com.hbl.mvpbase.di.module;

import com.hbl.mvpbase.BuildConfig;
import com.hbl.mvpbase.app.Constants;
import com.hbl.mvpbase.di.qualifier.DoDoUrl;
import com.hbl.mvpbase.di.qualifier.WechatUrl;
import com.hbl.mvpbase.model.api.DoDoApis;
import com.hbl.mvpbase.model.api.WeChatApis;
import com.hbl.mvpbase.util.SystemUtil;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

@Module
public class HttpModule {

    /**
     * 设置不同的业务接口
     * @return
     */
    @Singleton
    @Provides
    Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }


    @Singleton
    @Provides
    OkHttpClient.Builder provideOkHttpBuilder() {
        return new OkHttpClient.Builder();
    }


    //Retrofit
    @Singleton
    @Provides
    @WechatUrl
    Retrofit provideWechatRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, WeChatApis.HOST);
    }

    //Retrofit
    @Singleton
    @Provides
    @DoDoUrl
    Retrofit provideDoDoRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, DoDoApis.HOST);
    }


    @Singleton
    @Provides
    OkHttpClient provideClient(OkHttpClient.Builder builder) {
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            builder.addInterceptor(loggingInterceptor);
        }
        File cacheFile = new File(Constants.PATH_CACHE);
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
        Interceptor cacheInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (!SystemUtil.isNetworkConnected()) {
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }
                Response response = chain.proceed(request);
                if (SystemUtil.isNetworkConnected()) {
                    int maxAge = 0;
                    // 有网络时, 不缓存, 最大保存时长为0
                    response.newBuilder()
                            .header("Cache-Control", "public, max-age=" + maxAge)
                            .removeHeader("Pragma")
                            .build();
                } else {
                    // 无网络时，设置超时为4周
                    int maxStale = 60 * 60 * 24 * 28;
                    response.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                            .removeHeader("Pragma")
                            .build();
                }
                return response;
            }
        };
//        Interceptor apikey = new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                Request request = chain.request();
//                request = request.newBuilder()
//                        .addHeader("apikey",Constants.KEY_API)
//                        .build();
//                return chain.proceed(request);
//            }
//        }
//        设置统一的请求头部参数
//        builder.addInterceptor(apikey);
        //设置缓存
        builder.addNetworkInterceptor(cacheInterceptor);
        builder.addInterceptor(cacheInterceptor);
        builder.cache(cache);


        //设置超时
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        //错误重连
        builder.retryOnConnectionFailure(true);
        return builder.build();
    }







    @Singleton
    @Provides
    WeChatApis provideWechatService(@WechatUrl Retrofit retrofit) {
        return retrofit.create(WeChatApis.class);
    }



    @Singleton
    @Provides
    DoDoApis provideDoDoService(@DoDoUrl Retrofit retrofit) {
        return retrofit.create(DoDoApis.class);
    }

    private Retrofit createRetrofit(Retrofit.Builder builder, OkHttpClient client, String url) {
        return builder
                .baseUrl(url)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                //重要，带文件 提交表单时，需要;
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }
}
