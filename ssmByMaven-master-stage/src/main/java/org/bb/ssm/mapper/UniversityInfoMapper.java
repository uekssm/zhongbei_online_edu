package org.bb.ssm.mapper;

import java.util.List;

import org.bb.ssm.model.University;

public interface UniversityInfoMapper {
	
	List<University> findAll();
	
    int deleteByPrimaryKey(Integer UniversityId);

    int insert(University record);

    int insertSelective(University record);

    University selectByPrimaryKey(Integer UniversityId);

    int updateByPrimaryKeySelective(University record);

    int updateByPrimaryKey(University record);

	University selectByPwd(University record);
}