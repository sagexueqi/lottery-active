package com.connie7.controller;

import com.connie7.service.AwardService;
import com.connie7.vo.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>抽奖奖品信息Controller</p>
 * <pre>
 *     author      XueQi
 *     date        2018/4/8
 *     email       job.xueqi@outlook.com
 * </pre>
 */
@RestController
@RequestMapping("/lottery/award")
public class LotteryAwardInfoController extends BaseController {
	private static Logger LOGGER = LoggerFactory.getLogger(LotteryAwardInfoController.class);

	@Autowired
	private AwardService awardService;

	/**
	 * 初始化奖品信息
	 *
	 * @return
	 */
	@RequestMapping(value = "init", method = RequestMethod.POST)
	public ResponseResult init() {
		awardService.initAward2Cache();
		return success();
	}

}
