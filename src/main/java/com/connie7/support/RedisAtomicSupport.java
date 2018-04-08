package com.connie7.support;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;

/**
 * <p>Redis原子工具类</p>
 * <pre>
 *     author      XueQi
 *     date        2018/4/8
 *     email       job.xueqi@outlook.com
 * </pre>
 */
public class RedisAtomicSupport {

	/**
	 * key自增操作
	 *
	 * @param key
	 * @param redisConnectionFactory
	 * @return
	 */
	public static long increment(String key, RedisConnectionFactory redisConnectionFactory, RedisAtomicCallBack callBack) {
		RedisAtomicLong redisAtomicLong = new RedisAtomicLong(key, redisConnectionFactory);
		long            value           = redisAtomicLong.incrementAndGet();
		callBack.callback(value, redisAtomicLong);
		return value;
	}

}
