package org.bb.ssm.mapper;

import java.util.List;

import org.bb.ssm.model.Indicators;

public interface IndicatorsInfoMapper {
	
	List<Indicators> findAll();
	
    int deleteByPrimaryKey(Integer IndicatorsId);

    int insert(Indicators record);

    int insertSelective(Indicators record);

    Indicators selectByPrimaryKey(Integer IndicatorsId);

    int updateByPrimaryKeySelective(Indicators record);

    int updateByPrimaryKey(Indicators record);

	Indicators selectByPwd(Indicators record);
}