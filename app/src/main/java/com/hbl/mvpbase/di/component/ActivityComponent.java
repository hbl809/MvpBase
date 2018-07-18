package com.hbl.mvpbase.di.component;

import android.app.Activity;

import com.hbl.mvpbase.di.module.ActivityModule;
import com.hbl.mvpbase.di.scope.ActivityScope;
import com.hbl.mvpbase.ui.main.activity.MainActivity;

import dagger.Component;

/**
 * 需要MVP的Activity需要在这里注册
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();

    //void inject(WelcomeActivity welcomeActivity);

    void inject(MainActivity mainActivity);

}
