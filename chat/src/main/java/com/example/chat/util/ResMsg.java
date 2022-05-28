package com.example.chat.util;

import java.io.Serializable;

/**
 * 响应实体类
 *
 * @author andilylzy
 * @data 2022/5/21 上午10:44
 */
public class ResMsg implements Serializable {

    /**
     * 成功
     */
    public static final int SUCCESS = Constants.SUCCESS;

    /**
     * 失败
     */
    public static final int FAIL = Constants.FAIL;

    private int code;

    private String msg;

    public static ResMsg ok(String msg) {
        return resMsg(SUCCESS,msg);
    }

    public static ResMsg fail(String msg){
        return resMsg(FAIL,msg);
    }

    private static ResMsg resMsg(int code,String msg) {
        ResMsg resMsg = new ResMsg();
        resMsg.setCode(code);
        resMsg.setMsg(msg);

        return resMsg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
