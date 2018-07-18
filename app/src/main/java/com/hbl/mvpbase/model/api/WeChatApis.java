package com.hbl.mvpbase.model.api;

import com.hbl.mvpbase.model.bean.WXItemBean;
import com.hbl.mvpbase.model.response.WXHttpResponse;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 某类业务接口
 */

public interface WeChatApis {

    String HOST = "http://api.tianapi.com/";
    /**
     * 微信精选列表
     */
    @GET("wxnew")
    Flowable<WXHttpResponse<List<WXItemBean>>> getWXHot(@Query("key") String key, @Query("num") int num, @Query("page") int page);

    /**
     * 微信精选列表
     */
    @GET("wxnew")
    Flowable<WXHttpResponse<List<WXItemBean>>> getWXHotSearch(@Query("key") String key, @Query("num") int num, @Query("page") int page, @Query("word") String word);
}
