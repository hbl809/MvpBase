package com.hbl.mvpbase.util;

import com.hbl.mvpbase.model.exception.ApiException;
import com.hbl.mvpbase.model.response.DoDoHttpResponse;
import com.hbl.mvpbase.model.response.GoldHttpResponse;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by codeest on 2016/8/3.
 */
public class RxUtil {

    /**
     * 统一线程处理
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<T, T> rxSchedulerHelper() {    //compose简化线程
        return new FlowableTransformer<T, T>() {
            @Override
            public Flowable<T> apply(Flowable<T> observable) {
                return observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }


    /**
     * 统一返回结果处理
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<DoDoHttpResponse<T>, T> handleHttpResult() {
        //compose判断结果
        return new FlowableTransformer<DoDoHttpResponse<T>, T>() {
            @Override
            public Flowable<T> apply(Flowable<DoDoHttpResponse<T>> httpResponseFlowable) {
                return httpResponseFlowable.flatMap(new Function<DoDoHttpResponse<T>, Flowable<T>>() {
                    @Override
                    public Flowable<T> apply(DoDoHttpResponse<T> tDoDoHttpResponse) throws Exception {
                        if(tDoDoHttpResponse.getErrcode() == 200) {
                            return createData(tDoDoHttpResponse.getData());
                        } else {
                            return Flowable.error(new ApiException(tDoDoHttpResponse.getMsg(),
                                    tDoDoHttpResponse.getErrcode()));
                        }
                    }

                });
            }
        };
    }

    /**
     * 统一返回结果处理
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<GoldHttpResponse<T>, T> handleGoldResult() {   //compose判断结果
        return new FlowableTransformer<GoldHttpResponse<T>, T>() {
            @Override
            public Flowable<T> apply(Flowable<GoldHttpResponse<T>> httpResponseFlowable) {
                return httpResponseFlowable.flatMap(new Function<GoldHttpResponse<T>, Flowable<T>>() {
                    @Override
                    public Flowable<T> apply(GoldHttpResponse<T> tGoldHttpResponse) {
                        if(tGoldHttpResponse.getResults() != null) {
                            return createData(tGoldHttpResponse.getResults());
                        } else {
                            return Flowable.error(new ApiException("服务器返回error"));
                        }
                    }
                });
            }
        };
    }

    /**
     * 生成Flowable
     * @param <T>
     * @return
     */
    public static <T> Flowable<T> createData(final T t) {
        return Flowable.create(new FlowableOnSubscribe<T>() {
            @Override
            public void subscribe(FlowableEmitter<T> emitter) throws Exception {
                try {
                    emitter.onNext(t);
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        }, BackpressureStrategy.BUFFER);
    }
}
