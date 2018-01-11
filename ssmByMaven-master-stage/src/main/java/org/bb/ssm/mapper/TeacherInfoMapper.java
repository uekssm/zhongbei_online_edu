package org.bb.ssm.mapper;

import java.util.List;

import org.bb.ssm.model.Teacher;

public interface TeacherInfoMapper {
	
	List<Teacher> findAll();
	
    int deleteByPrimaryKey(Integer TeacherId);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer TeacherId);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

	Teacher selectByPwd(Teacher record);
}