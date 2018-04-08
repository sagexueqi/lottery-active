package com.connie7.service;

/**
 * <p>抽奖服务</p>
 * <pre>
 *     author      XueQi
 *     date        2018/4/8
 *     email       sage.xue@vipshop.com
 * </pre>
 */
public interface LotteryService {

	/**
	 * 汇总用户当天抽奖次数
	 *
	 * @param userId
	 * @return
	 */
	int countUserTodayTimes(long userId);

	/**
	 * 抽奖操作
	 *
	 * @return 奖品id
	 */
	long lotteryAction();
}
