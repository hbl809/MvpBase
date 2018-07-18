package com.hbl.mvpbase.model.api;

import com.hbl.mvpbase.model.bean.GradeBean;
import com.hbl.mvpbase.model.bean.SubjectBean;
import com.hbl.mvpbase.model.bean.TokenBean;
import com.hbl.mvpbase.model.response.DoDoHttpResponse;

import java.util.ArrayList;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface DoDoApis {

    String HOST = "https://api.dodoedu.com/";


    /**
     * 取默认令牌，没有登录时候的令牌
     *
     * @param app_id
     * @param app_key
     * @param client_secret
     * @return
     */
    @FormUrlEncoded
    @POST("v1/auth/grantaccesstokenbyclientkey")
    Flowable<TokenBean> getDefaultToken(@Field("app_id") String app_id,
                                          @Field("app_key") String app_key,
                                          @Field("client_secret") String client_secret
    );

    //取年级列表
    @FormUrlEncoded
    @POST("v1/Jc/Study/rightnotelist")
    Flowable<DoDoHttpResponse<ArrayList<GradeBean>>> getGradeList(@Field("access_token") String
                                                                  access_token);


    //取主题分类列表
    @FormUrlEncoded
    @POST("v1/Jc/Resource/getsubjectcount")
    Flowable<DoDoHttpResponse<ArrayList<SubjectBean>>> getSubjectList(@Field("access_token") String
                                                                      access_token);



    /**
     * 技术文章列表
     */
    //@GET("data/{tech}/{num}/{page}")
    //Flowable<GankHttpResponse<List<GankItemBean>>> getTechList(@Path("tech") String tech, @Path
     //       ("num") int num, @Path("page") int page);


}
