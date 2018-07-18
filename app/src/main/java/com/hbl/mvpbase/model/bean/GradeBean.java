package com.hbl.mvpbase.model.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/11/3 0003.
 */
//年级版本信息
public class GradeBean implements Serializable {

    private String bb;
    private String name;
    private String nj;
    private String xd;
    private String xk;

    public String getBb() {
        return bb;
    }

    public void setBb(String bb) {
        this.bb = bb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNj() {
        return nj;
    }

    public void setNj(String nj) {
        this.nj = nj;
    }

    public String getXd() {
        return xd;
    }

    public void setXd(String xd) {
        this.xd = xd;
    }

    public String getXk() {
        return xk;
    }

    public void setXk(String xk) {
        this.xk = xk;
    }
}
