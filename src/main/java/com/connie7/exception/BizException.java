package com.connie7.exception;

import com.connie7.values.ResponseCode;
import org.springframework.util.StringUtils;

/**
 * <p>业务异常</p>
 * <pre>
 *     author      XueQi
 *     date        2018/4/8
 *     email       job.xueqi@outlook.com
 * </pre>
 */
public class BizException extends RuntimeException {
	protected String message;
	protected String code;

	public BizException(String message) {
		this.message = message;
	}

	public BizException(String message, Exception e) {
		super(e);
		this.message = message;
	}

	public BizException(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public BizException(ResponseCode responseCode) {
		this.code = responseCode.getCode();
		this.message = responseCode.getDesc();
	}

	public BizException(Exception e) {
		super(e);
	}

	public String getCode() {
		return this.code;
	}

	@Override
	public String getMessage() {
		return StringUtils.isEmpty(this.message) ? super.getMessage() : this.message;
	}
}
