package org.bb.ssm.mapper;

import java.util.List;

import org.bb.ssm.model.Titles;

public interface TitlesInfoMapper {
	
	List<Titles> findAll();
	
    int deleteByPrimaryKey(Integer TitlesId);

    int insert(Titles record);

    int insertSelective(Titles record);

    Titles selectByPrimaryKey(Integer TitlesId);

    int updateByPrimaryKeySelective(Titles record);

    int updateByPrimaryKey(Titles record);

	Titles selectByPwd(Titles record);
}