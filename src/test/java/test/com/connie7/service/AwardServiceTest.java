package test.com.connie7.service;

import com.connie7.service.AwardService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.com.connie7.BaseTest;

/**
 * <p></p>
 * <pre>
 *     author      XueQi
 *     date        2018/4/7
 *     email       job.xueqi@outlook.com
 * </pre>
 */
public class AwardServiceTest extends BaseTest {
	@Autowired
	private AwardService awardService;

	@Test
	public void initAward2CacheTest() {
		awardService.initAward2Cache();
	}
}
