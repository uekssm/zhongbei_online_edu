package org.bb.ssm.mapper;

import java.util.List;

import org.bb.ssm.model.Team;

public interface TeamInfoMapper {
	
	List<Team> findAll();
	
    int deleteByPrimaryKey(Integer TeamId);

    int insert(Team record);

    int insertSelective(Team record);

    Team selectByPrimaryKey(Integer TeamId);

    int updateByPrimaryKeySelective(Team record);

    int updateByPrimaryKey(Team record);

	Team selectByPwd(Team record);
}