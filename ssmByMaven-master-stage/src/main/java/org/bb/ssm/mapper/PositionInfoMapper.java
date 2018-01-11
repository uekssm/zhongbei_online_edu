package org.bb.ssm.mapper;

import java.util.List;

import org.bb.ssm.model.Position;

public interface PositionInfoMapper {
	
	List<Position> findAll();
	
    int deleteByPrimaryKey(Integer userId);

    int insert(Position record);

    int insertSelective(Position record);

    Position selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);

	List<Position> findOne();
	
	List<Position> findPage();
}