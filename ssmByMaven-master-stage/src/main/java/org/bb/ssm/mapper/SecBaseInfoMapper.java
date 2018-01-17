package org.bb.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.bb.ssm.model.SecBase;

public interface SecBaseInfoMapper {
	
	List<SecBase> findAll();
	
    int deleteByPrimaryKey(Integer userId);

    int insert(SecBase record);

    int insertSelective(SecBase record);

    SecBase selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(SecBase record);

    int updateByPrimaryKey(SecBase record);

	SecBase selectByPwd(SecBase record);

	String findtimeByUserid(@Param(value="user_id") Integer user_id);

	void deleteByUserid(@Param(value="user_id") Integer user_id);
}