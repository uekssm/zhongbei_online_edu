package org.bb.ssm.mapper;

import java.util.List;

import org.bb.ssm.model.Role;

public interface RoleInfoMapper {
	
	List<Role> findAll();
	
    int deleteByPrimaryKey(Integer userId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}