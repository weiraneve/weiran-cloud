package com.weiran.common.code;

public enum CodeDesc {
	/**
	 *
	 */
	SUCCESS("成功", 200),
	FAILURE("失败", 400),
	NO_AUTHORITY("权限不足", 403),
	FILE_UPLOAD_FAILURE("文件上传失败！", 400),
	MAIL_IS_ERR("邮箱不合法", 400),
	VERIFY_FAILED_VALIDATION_CODE("验证码错误", 400),
	GRAPHIC_CHECK_CODE_ERR("图形验证码错误", 400),
	FILE_IS_NULL("文件不能为空！", 400),
	PHONE_NUMBER_REGISTERED("该手机号已被绑定", 400),
	PHONE_NUMBER_IS_ERROR("手机号错误", 400),
	LOGIN_USER_NOT_EXIST("用户不存在", 400),
	MAIL_REGISTERED("该邮箱已被绑定", 400),
	ID_NUMBER_IS_ERR("身份证号不合法", 400),
	;
	// 成员变量
	private String name;
	private int code;

	// 构造方法
	private CodeDesc(String name, int code) {
		this.name = name;
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public int getCode() {
		return code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
