package com.connie7.service.impl;

import com.connie7.entity.LotteryInfoEntity;
import com.connie7.repository.LotteryInfoRepository;
import com.connie7.service.AwardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import sun.misc.Timer;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p></p>
 * <pre>
 *     author      XueQi
 *     date        2018/4/7
 *     email       sage.xue@vipshop.com
 * </pre>
 */
@Service
public class AwardServiceImpl implements AwardService {
	private static Logger LOGGER = LoggerFactory.getLogger(AwardServiceImpl.class);

	@Autowired
	private RedisTemplate         redisTemplate;
	@Autowired
	private LotteryInfoRepository lotteryInfoRepository;

	@Override
	public void initAward2Cache() {
		List<LotteryInfoEntity> list = lotteryInfoRepository.selectByEffective("1");
		if (list != null && list.size() > 0) {
			LOGGER.info("init award to cache, list size=[{}]", list.size());
			for (LotteryInfoEntity lotteryInfo : list) {
				// 将奖品信息写入到缓存中
				// key: lottery_award_id value:current_number
				redisTemplate.opsForValue().set("lottery_award_" + lotteryInfo.getId(), lotteryInfo.getCurrentNumber(), 90, TimeUnit.DAYS);
			}
		}
	}

	@Override
	public void modifyAwardCurrentNumber(long id, long usedNumber) {

	}
}
