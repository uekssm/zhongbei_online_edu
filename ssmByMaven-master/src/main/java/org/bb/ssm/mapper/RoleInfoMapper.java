package org.bb.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.bb.ssm.model.Role;

public interface RoleInfoMapper {
	
	List<Role> findAll(@Param(value="limit") Integer limit,@Param(value="pageIndex") Integer pageIndex,@Param(value="searchname") String searchname);
	
    int deleteByPrimaryKey(Integer userId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

	int getRoleCount(@Param(value="searchname") String searchname);
}