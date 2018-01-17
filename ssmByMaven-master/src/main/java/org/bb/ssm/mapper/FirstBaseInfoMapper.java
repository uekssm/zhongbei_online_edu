package org.bb.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.bb.ssm.model.FirstBase;
import org.bb.ssm.model.FirstBase;

public interface FirstBaseInfoMapper {
	
	List<FirstBase> findAll();
	
    int deleteByPrimaryKey(Integer userId);

    int insert(FirstBase record);

    int insertSelective(FirstBase record);

    FirstBase selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(FirstBase record);

    int updateByPrimaryKey(FirstBase record);

	FirstBase selectByPwd(FirstBase record);

	int deleteByUserid(@Param(value="user_id") Integer user_id);

	int deleteByRoleid(@Param(value="id") Integer id);

	int bindmenu(FirstBase rolemenu);
}