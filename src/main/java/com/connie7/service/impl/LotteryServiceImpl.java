package com.connie7.service.impl;

import com.connie7.repository.UserTakeinRepository;
import com.connie7.service.LotteryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <p></p>
 * <pre>
 *     author      XueQi
 *     date        2018/4/8
 *     email       sage.xue@vipshop.com
 * </pre>
 */
@Service
public class LotteryServiceImpl implements LotteryService {
	private static Logger LOGGER = LoggerFactory.getLogger(LotteryServiceImpl.class);

	// 线程安全 随机数
	private static ThreadLocalRandom random = ThreadLocalRandom.current();

	@Autowired
	private UserTakeinRepository userTakeinRepository;

	@Override
	@Transactional(readOnly = true)
	public int countUserTodayTimes(long userId) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String           date             = simpleDateFormat.format(new Date());

		int count = userTakeinRepository.selectCountByUserAndDate(userId, date);
		LOGGER.info("count user today lottery times, user_id=[{}],date=[{}],times=[{}]", userId, date, count);
		return count;
	}

	@Override
	public long lotteryAction() {
		long awardId = 0L;
		/**
		 * 中奖逻辑模拟数据
		 */
		float seed = random.nextFloat();
		if (seed > 0F && seed <= 0.1F) awardId = 1L;
		if (seed > 0.1F && seed <= 0.3F) awardId = 2L;
		if (seed > 0.3F && seed <= 0.5F) awardId = 3L;

		return awardId;
	}
}
