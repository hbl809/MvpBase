package com.hbl.mvpbase.presenter.main;

import com.hbl.mvpbase.base.RxPresenter;
import com.hbl.mvpbase.contract.main.MainContract;
import com.hbl.mvpbase.model.http.DataManager;

import javax.inject.Inject;

/**
 * Created by codeest on 16/8/9.
 */

public class MainPresenter extends RxPresenter<MainContract.View> implements MainContract.Presenter{

    private DataManager mDataManager;

    @Inject
    public MainPresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    @Override
    public void attachView(MainContract.View view) {
        super.attachView(view);
        //registerEvent();
    }

//    private void registerEvent() {
//        addSubscribe(RxBus.getDefault().toFlowable(NightModeEvent.class)
//                .compose(RxUtil.<NightModeEvent>rxSchedulerHelper())
//                .map(new Function<NightModeEvent, Boolean>() {
//                    @Override
//                    public Boolean apply(NightModeEvent nightModeEvent) {
//                        return nightModeEvent.getNightMode();
//                    }
//                })
//                .subscribeWith(new CommonSubscriber<Boolean>(mView, "切换模式失败ヽ(≧Д≦)ノ") {
//                    @Override
//                    public void onNext(Boolean aBoolean) {
//                        mView.useNightMode(aBoolean);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        super.onError(e);
//                        registerEvent();
//                    }
//                })
//        );
//    }





}
