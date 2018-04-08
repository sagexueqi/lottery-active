package com.connie7.support;

import org.springframework.data.redis.support.atomic.RedisAtomicLong;

/**
 * <p>Redis原子操作回调</p>
 * <pre>
 *     author      XueQi
 *     date        2018/4/8
 *     email       sage.xue@vipshop.com
 * </pre>
 */
public interface RedisAtomicCallBack {
	/**
	 * 回调操作
	 *
	 * @param value           自增后结果
	 * @param redisAtomicLong Atomic long backed by Redis
	 * @return
	 */
	void callback(long value, RedisAtomicLong redisAtomicLong);

}
