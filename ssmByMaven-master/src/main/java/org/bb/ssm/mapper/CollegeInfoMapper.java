package org.bb.ssm.mapper;

import java.util.List;

import org.bb.ssm.model.College;

public interface CollegeInfoMapper {
	
	List<College> findAll();
	
    int deleteByPrimaryKey(Integer CollegeId);

    int insert(College record);

    int insertSelective(College record);

    College selectByPrimaryKey(Integer CollegeId);

    int updateByPrimaryKeySelective(College record);

    int updateByPrimaryKey(College record);

	College selectByPwd(College record);

	List<College> findAllCollege();
}