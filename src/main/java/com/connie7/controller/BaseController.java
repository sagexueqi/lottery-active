package com.connie7.controller;

import com.connie7.vo.ResponseResult;

/**
 * <p></p>
 * <pre>
 *     author      XueQi
 *     date        2018/4/8
 *     email       job.xueqi@outlook.com
 * </pre>
 */
public class BaseController {

	/**
	 * 成功响应
	 *
	 * @param result
	 * @param <T>
	 * @return
	 */
	protected <T> ResponseResult<T> success(T result) {
		ResponseResult<T> responseResult = new ResponseResult<>();
		responseResult.setResult(result);
		return responseResult;
	}

	/**
	 * 成功响应 无返回结果
	 *
	 * @return
	 */
	protected ResponseResult success() {
		ResponseResult responseResult = new ResponseResult();
		return responseResult;
	}
}
