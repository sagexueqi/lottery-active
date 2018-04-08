package com.connie7.vo;

/**
 * <p>响应结果</p>
 * <pre>
 *     author      XueQi
 *     date        2018/4/8
 *     email       job.xueqi@outlook.com
 * </pre>
 */
public class ResponseResult<T> {
	private String code    = "0000";
	private String message = "SUCCESS";
	private T      result  = null;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}
}
