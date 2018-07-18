package com.hbl.mvpbase.di.module;

import com.hbl.mvpbase.app.App;
import com.hbl.mvpbase.model.http.DataManager;
import com.hbl.mvpbase.model.http.HttpHelper;
import com.hbl.mvpbase.model.http.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private final App application;

    public AppModule(App application) {
        this.application = application;
    }

    @Provides
    @Singleton
    App provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    HttpHelper provideHttpHelper(RetrofitHelper retrofitHelper) {
        return retrofitHelper;
    }

//    @Provides
//    @Singleton
//    DBHelper provideDBHelper(RealmHelper realmHelper) {
//        return realmHelper;
//    }

//    @Provides
//    @Singleton
//    PreferencesHelper providePreferencesHelper(ImplPreferencesHelper implPreferencesHelper) {
//        return implPreferencesHelper;
//    }

//    @Provides
//    @Singleton
//    DataManager provideDataManager(HttpHelper httpHelper, DBHelper DBHelper, PreferencesHelper preferencesHelper) {
//        return new DataManager(httpHelper, DBHelper, preferencesHelper);
//    }


    @Provides
    @Singleton
    DataManager provideDataManager(HttpHelper httpHelper) {
        return new DataManager(httpHelper);
    }
}
