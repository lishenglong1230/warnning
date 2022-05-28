package com.example.chat.entity;

import java.io.Serializable;

public class RestMsg<T> implements Serializable {

    private int code;

    private String msg;

    private T data;

    /**
     * 成功标记
     */
    public static final Integer SUCCESS = 200;

    /**
     * 失败标记
     */
    public static final Integer FAIL = 500;

    public static <T> RestMsg<T> ok(String msg) {
        return restResult(null, SUCCESS, msg);
    }
    public static <T> RestMsg<T> fail(String msg) {
        return restResult(null, FAIL, msg);
    }

    private static <T> RestMsg<T> restResult(T data, int code, String msg) {
        RestMsg<T> restMsg = new RestMsg<>();
        restMsg.setCode(code);
        restMsg.setData(data);
        restMsg.setMsg(msg);
        return restMsg;
    }

    public void setCode(int code) {
        this.code = code;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public void setData(T data) {
        this.data = data;
    }

}
