package com.connie7.service;

/**
 * <p>奖品服务</p>
 * <pre>
 *     author      XueQi
 *     date        2018/4/7
 *     email       sage.xue@vipshop.com
 * </pre>
 */
public interface AwardService {

	/**
	 * 初始化奖品信息到缓存
	 */
	void initAward2Cache();

	/**
	 * 修改奖品当前数量
	 *
	 * @param id         奖品id
	 * @param usedNumber 奖品使用数
	 */
	void modifyAwardCurrentNumber(long id, long usedNumber);
}
