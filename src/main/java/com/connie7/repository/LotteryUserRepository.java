package com.connie7.repository;

import com.connie7.entity.LotteryUserEntity;

public interface LotteryUserRepository {
    int deleteByPrimaryKey(Long id);

    int insert(LotteryUserEntity record);

    int insertSelective(LotteryUserEntity record);

    LotteryUserEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LotteryUserEntity record);

    int updateByPrimaryKey(LotteryUserEntity record);
}