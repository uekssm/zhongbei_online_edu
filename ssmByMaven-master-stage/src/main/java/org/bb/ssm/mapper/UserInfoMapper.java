package org.bb.ssm.mapper;

import java.util.List;

import org.bb.ssm.model.User;

public interface UserInfoMapper {
	
	List<User> findAll();
	
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	User selectByPwd(User record);
}