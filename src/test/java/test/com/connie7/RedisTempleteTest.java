package test.com.connie7;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

/**
 * <p></p>
 * <pre>
 *     author      XueQi
 *     date        2018/4/7
 *     email       sage.xue@vipshop.com
 * </pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:xml/applicationContext.xml"})
public class RedisTempleteTest {
	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	public void test() {
		RedisAtomicLong redisAtomicLong = new RedisAtomicLong("test_incr1", redisTemplate.getConnectionFactory());
		long            value           = redisAtomicLong.incrementAndGet();
		if (value == 1L) {
			redisAtomicLong.expire(24, TimeUnit.HOURS);
		}
		System.out.println(value);
	}

}
