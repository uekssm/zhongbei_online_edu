package org.bb.ssm.mapper;

import java.util.List;

import org.bb.ssm.model.Knowledge;

public interface KnowledgeInfoMapper {
	
	List<Knowledge> findAll();
	
    int deleteByPrimaryKey(Integer KnowledgeId);

    int insert(Knowledge record);

    int insertSelective(Knowledge record);

    Knowledge selectByPrimaryKey(Integer KnowledgeId);

    int updateByPrimaryKeySelective(Knowledge record);

    int updateByPrimaryKey(Knowledge record);

	Knowledge selectByPwd(Knowledge record);

	List<Knowledge> selectByCourseId(Integer id);
}