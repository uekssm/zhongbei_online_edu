package org.bb.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.bb.ssm.model.Subject;

public interface SubjectInfoMapper {
	
	List<Subject> findAll();
	
    int deleteByPrimaryKey(Integer SubjectId);

    int insert(Subject record);

    int insertSelective(Subject record);

    Subject selectByPrimaryKey(Integer SubjectId);

    int updateByPrimaryKeySelective(Subject record);

    int updateByPrimaryKey(Subject record);

	Subject selectByPwd(Subject record);

	List<Subject> findAllMajor(@Param(value="collegeId") int collegeId);
}