package org.bb.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.bb.ssm.model.Position;

public interface PositionInfoMapper {
	
	List<Position> findAll(@Param(value="limit") Integer limit,@Param(value="pageIndex") Integer pageIndex,@Param(value="searchname") String searchname,@Param(value="department_id") Integer department_id);
	
    int deleteByPrimaryKey(Integer userId);

    int insert(Position record);

    int insertSelective(Position record);

    Position selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);

	List<Position> findOne();
	
	List<Position> findPage();

	int getPositionCount(@Param(value="searchname") String searchname,@Param(value="department_id") Integer department_id);

	int findRoleidById(@Param(value="id") Integer id);
}