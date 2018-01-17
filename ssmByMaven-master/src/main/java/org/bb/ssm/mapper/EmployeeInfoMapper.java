package org.bb.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.bb.ssm.model.Employee;

public interface EmployeeInfoMapper {
	
	List<Employee> findAll(@Param(value="limit") Integer limit,@Param(value="pageIndex") Integer pageIndex,@Param(value="searchname") String searchname,@Param(value="position_id") Integer position_id);
	
    int deleteByPrimaryKey(Integer userId);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

	List<Employee> findOne();
	
	List<Employee> findPage();

	int getEmployeeCount(@Param(value="searchname") String searchname,@Param(value="position_id") Integer position_id);
}