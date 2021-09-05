package com.weiran.common.exception;

/**
 * 通一事务异常
 * @author Robin
 *
 */
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BusinessException(String arg0) {
		super(arg0);
	}
}
