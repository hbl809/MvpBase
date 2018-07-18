package com.hbl.mvpbase.model.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/11/17 0017.
 */

public class SubjectBean implements Serializable {

    private String cover_path;
    private  int num;
    private String subject;
    private String node_id;

    public String getCover_path() {
        return cover_path;
    }

    public void setCover_path(String cover_path) {
        this.cover_path = cover_path;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getNode_id() {
        return node_id;
    }

    public void setNode_id(String node_id) {
        this.node_id = node_id;
    }
}
