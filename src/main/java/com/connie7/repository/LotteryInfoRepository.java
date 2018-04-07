package com.connie7.repository;

import com.connie7.entity.LotteryInfoEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LotteryInfoRepository {
	int deleteByPrimaryKey(Long id);

	int insert(LotteryInfoEntity record);

	int insertSelective(LotteryInfoEntity record);

	LotteryInfoEntity selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(LotteryInfoEntity record);

	int updateByPrimaryKey(LotteryInfoEntity record);

	//.......//

	/**
	 * 根据生效状态查询
	 *
	 * @param effective
	 * @return
	 */
	List<LotteryInfoEntity> selectByEffective(@Param("effective") String effective);
}