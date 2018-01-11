package org.bb.ssm.mapper;

import java.util.List;

import org.bb.ssm.model.Classroom;

public interface ClassroomInfoMapper {
	
	List<Classroom> findAll();
	
    int deleteByPrimaryKey(Integer ClassroomId);

    int insert(Classroom record);

    int insertSelective(Classroom record);

    Classroom selectByPrimaryKey(Integer ClassroomId);

    int updateByPrimaryKeySelective(Classroom record);

    int updateByPrimaryKey(Classroom record);

	Classroom selectByPwd(Classroom record);
}