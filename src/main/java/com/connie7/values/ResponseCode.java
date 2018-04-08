package com.connie7.values;

/**
 * <p>响应码</p>
 * <pre>
 *     author      XueQi
 *     date        2018/4/8
 *     email       job.xueqi@outlook.com
 * </pre>
 */
public enum ResponseCode {
	USER_TODAY_MAX_LOTTERY_TIMES("1001", "用户当天抽奖次数已达上限");

	private String code;
	private String desc;

	ResponseCode(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

}
