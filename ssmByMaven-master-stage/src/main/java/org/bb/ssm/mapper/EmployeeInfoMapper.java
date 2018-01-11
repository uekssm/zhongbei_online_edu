package org.bb.ssm.mapper;

import java.util.List;

import org.bb.ssm.model.Employee;

public interface EmployeeInfoMapper {
	
	List<Employee> findAll();
	
    int deleteByPrimaryKey(Integer userId);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

	List<Employee> findOne();
	
	List<Employee> findPage();
}