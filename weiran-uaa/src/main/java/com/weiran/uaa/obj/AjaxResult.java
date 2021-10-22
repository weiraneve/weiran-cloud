package com.weiran.uaa.obj;

import lombok.Data;

/**
 * @ClassName AjaxResult.java
 * @Description ajax、json返回数据
 */
@Data
public class AjaxResult {

    private static final long serialVersionUID = 1L;	// 序列化版本号

    public static final int CODE_SUCCESS = 200;			// 成功状态码
    public static final int CODE_ERROR = 500;			// 错误状态码
    public static final int CODE_WARNING = 501;			// 警告状态码
    public static final int CODE_NOT_JUR = 403;			// 无权限状态码
    public static final int CODE_NOT_LOGIN = 401;		// 未登录状态码
    public static final int CODE_INVALID_REQUEST = 400;	// 无效请求状态码

    private boolean success;
    private String message;
    private int code;
    private String imgurl;
    private String type;
    private String name;

    public boolean isSuccess() {
        return success;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}
