package com.hbl.mvpbase.model.http;

import com.hbl.mvpbase.app.Constants;
import com.hbl.mvpbase.model.api.DoDoApis;
import com.hbl.mvpbase.model.api.WeChatApis;
import com.hbl.mvpbase.model.bean.TokenBean;
import com.hbl.mvpbase.model.bean.WXItemBean;
import com.hbl.mvpbase.model.response.WXHttpResponse;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;


public class RetrofitHelper implements HttpHelper {
    private WeChatApis mWechatApiService;
    private DoDoApis mDoDoApiService;

    @Inject
    public RetrofitHelper( WeChatApis wechatApiService, DoDoApis dodoApiService) {
        this.mWechatApiService = wechatApiService;
        this.mDoDoApiService=dodoApiService;
    }


    @Override
    public Flowable<WXHttpResponse<List<WXItemBean>>> fetchWechatListInfo(int num, int page) {
        return mWechatApiService.getWXHot(Constants.KEY_API, num, page);
    }

    @Override
    public Flowable<WXHttpResponse<List<WXItemBean>>> fetchWechatSearchListInfo(int num, int page, String word) {
        return mWechatApiService.getWXHotSearch(Constants.KEY_API, num, page, word);
    }



    @Override
    public Flowable<TokenBean> getToken(String app_id, String app_key, String client_secret) {
        return mDoDoApiService.getDefaultToken(app_id,app_key,client_secret);
    }

}
