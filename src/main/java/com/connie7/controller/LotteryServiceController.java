package com.connie7.controller;

import com.connie7.exception.BizException;
import com.connie7.service.LotteryService;
import com.connie7.values.ResponseCode;
import com.connie7.vo.AwardInfoVO;
import com.connie7.vo.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>抽奖服务Controller</p>
 * <pre>
 *     author      XueQi
 *     date        2018/4/8
 *     email       job.xueqi@outlook.com
 * </pre>
 */
@RestController
@RequestMapping("/lottery/service")
public class LotteryServiceController extends BaseController {
	private static Logger LOGGER = LoggerFactory.getLogger(LotteryServiceController.class);

	@Autowired
	private LotteryService lotteryService;

	/**
	 * 抽奖逻辑
	 *
	 * @param userId
	 * @return
	 */
	public ResponseResult<AwardInfoVO> action(long userId) {
		LOGGER.info("execute lottery action, user_id=[{}]", userId);

		// 1. 获取用户当天可抽奖总次数, 模拟 = 2
		int allowLotteryTimes = 2;

		// 2. 判断用户数据库中当天抽奖次数 数据库层面对多次抽奖做拦截
		int lotteryTimes = lotteryService.countUserTodayTimes(userId);
		if (lotteryTimes >= allowLotteryTimes) {
			throw new BizException(ResponseCode.USER_TODAY_MAX_LOTTERY_TIMES);
		}

		// 3. 计算获奖情况,不作为最终的获奖结果

		return null;
	}

}
