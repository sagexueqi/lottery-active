package com.connie7.service.impl;

import com.connie7.entity.LotteryInfoEntity;
import com.connie7.repository.LotteryInfoRepository;
import com.connie7.service.AwardService;
import com.connie7.values.CacheKeyPrefix;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.Timer;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p></p>
 * <pre>
 *     author      XueQi
 *     date        2018/4/7
 *     email       job.xueqi@outlook.com
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
				redisTemplate.opsForValue().set(CacheKeyPrefix.LOTTERY_AWARD_PREFIX + lotteryInfo.getId(), lotteryInfo.getCurrentNumber(), 90, TimeUnit.DAYS);
			}
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void modifyAwardCurrentNumber(long id, long usedNumber) {
		LotteryInfoEntity awardInfo = lotteryInfoRepository.selectByPrimaryKeyForLock(id);
		if (awardInfo != null && (awardInfo.getInitNumber() - usedNumber >= 0)) {
			Date oldUpdateDate = awardInfo.getUpdateTime();
			awardInfo.setCurrentNumber(awardInfo.getInitNumber() - usedNumber);
			awardInfo.setUpdateTime(new Date());

			// 更新结果
			int num = lotteryInfoRepository.updateByPrimaryKeyAndUpdateTime(awardInfo, oldUpdateDate);
			LOGGER.info("modify award current number, id=[{}] usedNumber=[{}],num=[{}]", id, usedNumber, num);
		}
	}
}
