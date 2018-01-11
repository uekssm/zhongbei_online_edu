package org.bb.ssm.mapper;

import java.util.List;

import org.bb.ssm.model.Students;

public interface StudentsInfoMapper {
	
	List<Students> findAll();
	
    int deleteByPrimaryKey(Integer StudentsId);

    int insert(Students record);

    int insertSelective(Students record);

    Students selectByPrimaryKey(Integer StudentsId);

    int updateByPrimaryKeySelective(Students record);

    int updateByPrimaryKey(Students record);

	Students selectByPwd(Students record);
}