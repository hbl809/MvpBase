package com.hbl.mvpbase.model.http;

import com.hbl.mvpbase.model.bean.TokenBean;
import com.hbl.mvpbase.model.bean.WXItemBean;
import com.hbl.mvpbase.model.response.WXHttpResponse;

import java.util.List;

import io.reactivex.Flowable;


public class DataManager implements HttpHelper {

    HttpHelper mHttpHelper;

    public DataManager(HttpHelper httpHelper) {
        mHttpHelper = httpHelper;
    }


    @Override
    public Flowable<WXHttpResponse<List<WXItemBean>>> fetchWechatListInfo(int num, int page) {
        return mHttpHelper.fetchWechatListInfo(num, page);
    }

    @Override
    public Flowable<WXHttpResponse<List<WXItemBean>>> fetchWechatSearchListInfo(int num, int page, String word) {
        return mHttpHelper.fetchWechatSearchListInfo(num, page, word);
    }

    @Override
    public Flowable<TokenBean> getToken(String app_id, String app_key, String client_secret) {
        return mHttpHelper.getToken(app_id, app_key, client_secret);
    }


}
