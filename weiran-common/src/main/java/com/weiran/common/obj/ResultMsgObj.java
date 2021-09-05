package com.weiran.common.obj;

import java.io.Serializable;

/**
 * 统一返回结构体
 * @param <T>
 */
public class ResultMsgObj<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 状态码
     */
    private int code = 200;
    /**
     * 返回消息
     */
    private String msg = "";
    /**
     * 返回结果参数
     */
    private T data;

    public ResultMsgObj() {
    }

    public ResultMsgObj(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
