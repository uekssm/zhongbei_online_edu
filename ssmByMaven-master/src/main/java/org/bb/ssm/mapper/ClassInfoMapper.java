package org.bb.ssm.mapper;

import java.util.List;

import org.bb.ssm.model.Class;

public interface ClassInfoMapper {
	
	List<Class> findAll();
	
    int deleteByPrimaryKey(Integer ClassId);

    int insert(Class record);

    int insertSelective(Class record);

    Class selectByPrimaryKey(Integer ClassId);

    int updateByPrimaryKeySelective(Class record);

    int updateByPrimaryKey(Class record);

	Class selectByPwd(Class record);
}