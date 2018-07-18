package com.hbl.mvpbase.di.component;

import com.hbl.mvpbase.app.App;
import com.hbl.mvpbase.di.module.AppModule;
import com.hbl.mvpbase.di.module.HttpModule;
import com.hbl.mvpbase.model.http.DataManager;
import com.hbl.mvpbase.model.http.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 全局的基本模块
 */

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    App getContext();  // 提供App的Context

     DataManager getDataManager(); //数据中心

     RetrofitHelper retrofitHelper();  //提供http的帮助类

    //RealmHelper realmHelper();    //提供数据库帮助类

    //ImplPreferencesHelper preferencesHelper(); //提供sp帮助类
}
