package com.hbl.mvpbase.di.component;

import android.app.Activity;

import com.hbl.mvpbase.di.module.FragmentModule;
import com.hbl.mvpbase.di.scope.FragmentScope;
import com.hbl.mvpbase.ui.main.fragment.TabBookFragment;
import com.hbl.mvpbase.ui.main.fragment.TabCollectionFragment;
import com.hbl.mvpbase.ui.main.fragment.TabMeFragment;
import com.hbl.mvpbase.ui.main.fragment.TabQuestionFragment;
import com.hbl.mvpbase.ui.main.fragment.TabSearchFragment;

import dagger.Component;

/**
 * 需要MVP的Fragment需要在这里注册
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();

    void inject(TabBookFragment dailyFragment);
    void inject(TabCollectionFragment themeFragment);
    void inject(TabMeFragment dailyFragment);
    void inject(TabQuestionFragment themeFragment);
    void inject(TabSearchFragment themeFragment);

}
