package com.hbl.mvpbase.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.hbl.mvpbase.app.App;
import com.hbl.mvpbase.di.component.DaggerFragmentComponent;
import com.hbl.mvpbase.di.component.FragmentComponent;
import com.hbl.mvpbase.di.module.FragmentModule;
import com.hbl.mvpbase.util.SnackbarUtil;

import javax.inject.Inject;

/**
 * MVP Fragment基类
 */
public abstract class BaseMvpFragment<T extends BasePresenter> extends BaseFragment implements
        BaseView {

    @Inject
    protected T mPresenter;

    protected FragmentComponent getFragmentComponent(){
        return DaggerFragmentComponent.builder()
                .appComponent(App.getAppComponent())
                .fragmentModule(getFragmentModule())
                .build();
    }

    protected FragmentModule getFragmentModule(){
        return new FragmentModule(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initInject();
        mPresenter.attachView(this);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        if (mPresenter != null) mPresenter.detachView();
        super.onDestroyView();
    }

    @Override
    public void showErrorMsg(String msg) {
        SnackbarUtil.show(((ViewGroup) getActivity().findViewById(android.R.id.content)).getChildAt(0), msg);
    }

    @Override
    public void useNightMode(boolean isNight) {

    }

    @Override
    public void stateError() {

    }

    @Override
    public void stateEmpty() {

    }

    @Override
    public void stateLoading() {

    }

    @Override
    public void stateMain() {

    }

    protected abstract void initInject();
}