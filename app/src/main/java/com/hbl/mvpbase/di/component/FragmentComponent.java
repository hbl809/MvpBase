package com.hbl.mvpbase.di.component;

import android.app.Activity;

import com.hbl.mvpbase.di.module.FragmentModule;
import com.hbl.mvpbase.di.scope.FragmentScope;
import com.hbl.mvpbase.ui.main.fragment.TabContactFragment;
import com.hbl.mvpbase.ui.main.fragment.TabDiscoverFragment;
import com.hbl.mvpbase.ui.main.fragment.TabMeFragment;
import com.hbl.mvpbase.ui.main.fragment.TabMessageFragment;
import com.hbl.mvpbase.ui.main.fragment.TabNewsFragment;

import dagger.Component;

/**
 * 需要MVP的Fragment需要在这里注册
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {
    Activity getActivity();
    void inject(TabNewsFragment tabNewsFragment);
    void inject(TabMessageFragment tabMessageFragment);
    void inject(TabContactFragment tabContactFragment);
    void inject(TabDiscoverFragment tabDiscoverFragment);
    void inject(TabMeFragment tabMeFragment);



}
