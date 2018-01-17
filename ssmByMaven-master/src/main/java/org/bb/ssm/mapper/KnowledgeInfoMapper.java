package org.bb.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.bb.ssm.model.Knowledge;

public interface KnowledgeInfoMapper {
	
	List<Knowledge> findAll();
	
    int deleteByPrimaryKey(@Param(value="ids") String[] ids);

    int insert(Knowledge record);

    int insertSelective(Knowledge record);

    Knowledge selectByPrimaryKey(Integer KnowledgeId);

    int updateByPrimaryKeySelective(Knowledge record);

    int updateByPrimaryKey(Knowledge record);

	Knowledge selectByPwd(Knowledge record);

	List<Knowledge> findAllByPage(@Param(value="limit") Integer limit,@Param(value="pageIndex") Integer pageIndex,@Param(value="searchname") String searchname,@Param(value="course_id") Integer course_id);

	int getKnowledgeCount(@Param(value="searchname") String searchname,@Param(value="course_id") Integer course_id);
}