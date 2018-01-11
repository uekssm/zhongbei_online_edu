package org.bb.ssm.mapper;

import java.util.List;

import org.bb.ssm.model.Department;

public interface DepartmentInfoMapper {
	
	List<Department> findAll();
	
    int deleteByPrimaryKey(Integer userId);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

	List<Department> findOne();
	
	List<Department> findPage();
}