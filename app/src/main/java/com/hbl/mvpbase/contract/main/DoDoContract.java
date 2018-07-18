package com.hbl.mvpbase.contract.main;

import com.hbl.mvpbase.base.BasePresenter;
import com.hbl.mvpbase.base.BaseView;
import com.hbl.mvpbase.model.bean.TokenBean;

/**
 * Created by codeest on 16/8/9.
 */

public interface DoDoContract {

    interface View extends BaseView {

        void showContent(TokenBean  tokenBean);
    }

    interface  Presenter extends BasePresenter<View> {

           void getToken( String app_id, String app_key, String client_secret);
    }
}
