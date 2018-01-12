package org.bb.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
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

	Object selectByCourseId(Integer id);

	List<Course> findAllCourse(@Param(value="limit") int limit ,@Param(value="offset") int pffset ,@Param(value="college_id") int college_id ,@Param(value="subject_id") int subject_id ,@Param(value="grade") int grade );

	int getCourseCount(@Param(value="college_id") int college_id ,@Param(value="subject_id") int subject_id ,@Param(value="grade") int grade);
}