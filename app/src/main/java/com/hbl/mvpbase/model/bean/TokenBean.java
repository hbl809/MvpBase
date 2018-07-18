package com.hbl.mvpbase.model.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/11/2 0002.
 */

public class TokenBean implements Serializable {
    private String access_token;
    private String refresh_token;
    private int expires_in;
    private int errcode;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }
}

