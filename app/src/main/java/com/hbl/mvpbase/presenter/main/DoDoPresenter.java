package com.hbl.mvpbase.presenter.main;

import com.hbl.mvpbase.base.RxPresenter;
import com.hbl.mvpbase.contract.main.DoDoContract;
import com.hbl.mvpbase.model.bean.TokenBean;
import com.hbl.mvpbase.model.http.DataManager;
import com.hbl.mvpbase.util.RxUtil;
import com.hbl.mvpbase.widget.CommonSubscriber;

import javax.inject.Inject;

/**
 * 多多社区接口测试
 */

public class DoDoPresenter extends RxPresenter<DoDoContract.View> implements DoDoContract.Presenter{

    private DataManager mDataManager;

    @Inject
    public DoDoPresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    @Override
    public void attachView(DoDoContract.View view) {
        super.attachView(view);
        //registerEvent();
    }

    @Override
    public void getToken(String app_id, String app_key, String client_secret) {

        addSubscribe(mDataManager.getToken(app_id,app_key,client_secret)
                .compose(RxUtil.<TokenBean>rxSchedulerHelper())
                //.compose(RxUtil.<TokenBean>handleHttpResult())
                .subscribeWith(new CommonSubscriber<TokenBean>(mView) {
                    @Override
                    public void onNext(TokenBean tokenBeanBean) {
                        mView.showContent(tokenBeanBean);
                    }

                })
        );
    }
}
