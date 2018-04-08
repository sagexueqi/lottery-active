package com.connie7.repository;

import com.connie7.entity.UserTakeinEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTakeinRepository {
	int deleteByPrimaryKey(Long id);

	int insert(UserTakeinEntity record);

	int insertSelective(UserTakeinEntity record);

	UserTakeinEntity selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(UserTakeinEntity record);

	int updateByPrimaryKey(UserTakeinEntity record);

	/**
	 * 根据用户和日期汇总
	 *
	 * @param userId
	 * @param date
	 * @return
	 */
	int selectCountByUserAndDate(@Param("userId") long userId, @Param("date") String date);
}