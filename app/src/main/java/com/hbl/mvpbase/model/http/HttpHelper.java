package com.hbl.mvpbase.model.http;


import com.hbl.mvpbase.model.bean.TokenBean;
import com.hbl.mvpbase.model.bean.WXItemBean;
import com.hbl.mvpbase.model.response.WXHttpResponse;

import java.util.List;

import io.reactivex.Flowable;


public interface HttpHelper {


    Flowable<WXHttpResponse<List<WXItemBean>>> fetchWechatListInfo(int num, int page);
    Flowable<WXHttpResponse<List<WXItemBean>>> fetchWechatSearchListInfo(int num, int page, String word);

    Flowable<TokenBean> getToken(String app_id, String app_key, String client_secret);

}
