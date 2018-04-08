package test.com.connie7.service;

import com.connie7.service.LotteryService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.com.connie7.BaseTest;

/**
 * <p></p>
 * <pre>
 *     author      XueQi
 *     date        2018/4/8
 *     email       sage.xue@vipshop.com
 * </pre>
 */
public class LotteryServiceTest extends BaseTest {

	@Autowired
	private LotteryService lotteryService;

	@Test
	public void countUserTodayTimesTest() {
		lotteryService.countUserTodayTimes(1L);
	}

}
