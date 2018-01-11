package org.bb.ssm.mapper;

import java.util.List;

import org.bb.ssm.model.Direction;

public interface DirectionInfoMapper {
	
	List<Direction> findAll();
	
    int deleteByPrimaryKey(Integer DirectionId);

    int insert(Direction record);

    int insertSelective(Direction record);

    Direction selectByPrimaryKey(Integer DirectionId);

    int updateByPrimaryKeySelective(Direction record);

    int updateByPrimaryKey(Direction record);

	Direction selectByPwd(Direction record);
}