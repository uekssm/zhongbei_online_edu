package org.bb.ssm.mapper;

import java.util.List;

import org.bb.ssm.model.Ability;

public interface AbilityInfoMapper {
	
	List<Ability> findAll();
	
    int deleteByPrimaryKey(Integer AbilityId);

    int insert(Ability record);

    int insertSelective(Ability record);

    Ability selectByPrimaryKey(Integer AbilityId);

    int updateByPrimaryKeySelective(Ability record);

    int updateByPrimaryKey(Ability record);

	Ability selectByPwd(Ability record);
}