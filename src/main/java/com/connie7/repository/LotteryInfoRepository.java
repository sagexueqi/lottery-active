package com.connie7.repository;

import com.connie7.entity.LotteryInfoEntity;

public interface LotteryInfoRepository {
    int deleteByPrimaryKey(Long id);

    int insert(LotteryInfoEntity record);

    int insertSelective(LotteryInfoEntity record);

    LotteryInfoEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LotteryInfoEntity record);

    int updateByPrimaryKey(LotteryInfoEntity record);
}