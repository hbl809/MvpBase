package com.hbl.mvpbase.base;

/**
 * Created by codeest on 2016/8/2.
 * Presenter基类
 */
public interface BasePresenter<T extends BaseView>{

    void attachView(T view);

    void detachView();
}
