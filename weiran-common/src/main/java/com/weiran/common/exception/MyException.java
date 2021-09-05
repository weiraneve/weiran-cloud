package com.weiran.common.exception;

/**
 * discription:
 *
 * @author luobin@jouav.com
 * @date 2019/10/25 0025 10:15
 */
public class MyException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public MyException(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
