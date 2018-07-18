package com.hbl.mvpbase.base;

import android.support.v7.app.AppCompatDelegate;
import android.view.ViewGroup;

import com.hbl.mvpbase.app.App;
import com.hbl.mvpbase.di.component.ActivityComponent;
import com.hbl.mvpbase.di.component.DaggerActivityComponent;
import com.hbl.mvpbase.di.module.ActivityModule;
import com.hbl.mvpbase.util.SnackbarUtil;

import javax.inject.Inject;

/**
 * MVP activity基类
 */
public abstract class BaseMvpActivity<T extends BasePresenter> extends BaseActivity implements BaseView {

    @Inject
    protected T mPresenter;

    protected ActivityComponent getActivityComponent(){
        return  DaggerActivityComponent.builder()
                .appComponent(App.getAppComponent())
                .activityModule(getActivityModule())
                .build();
    }

    protected ActivityModule getActivityModule(){
        return new ActivityModule(this);
    }

    @Override
    protected void onViewCreated() {
        super.onViewCreated();
        initInject();
        if (mPresenter != null)
            mPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null)
            mPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public void showErrorMsg(String msg) {
        SnackbarUtil.show(((ViewGroup) findViewById(android.R.id.content)).getChildAt(0), msg);
    }

    @Override
    public void useNightMode(boolean isNight) {
        if (isNight) {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_NO);
        }
        recreate();
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