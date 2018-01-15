package org.bb.ssm.mapper;

import java.util.List;

import org.bb.ssm.model.Course;

public interface CourseInfoMapper {
	
	List<Course> findAll();
	
    int deleteByPrimaryKey(Integer CourseId);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer CourseId);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

	Course selectByPwd(Course record);

	int getIdByNum(String num);
}