package com.hbl.mvpbase.model.response;

import java.io.Serializable;

/**
 * @author ChayChan
 * @description: 访问返回的response
 * @date 2017/6/18  19:37
 */
public class DoDoHttpResponse<T> implements Serializable {


    /**
     * code : 200
     * totalPage : 0
     * msg : 添加成功!
     * content : null
     */

    private int errcode;
    private String msg;
    private Long response_timestamp;


    private T data;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }



    public Long getResponse_timestamp() {
        return response_timestamp;
    }

    public void setResponse_timestamp(Long response_timestamp) {
        this.response_timestamp = response_timestamp;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
