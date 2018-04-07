package com.connie7.repository;

import com.connie7.entity.UserTakeinEntity;

public interface UserTakeinRepository {
    int deleteByPrimaryKey(Long id);

    int insert(UserTakeinEntity record);

    int insertSelective(UserTakeinEntity record);

    UserTakeinEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserTakeinEntity record);

    int updateByPrimaryKey(UserTakeinEntity record);
}