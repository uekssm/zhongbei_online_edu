package org.bb.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.bb.ssm.model.User;

public interface UserInfoMapper {
	
	List<User> findAll(@Param(value="limit") Integer limit,@Param(value="pageIndex") Integer pageIndex,@Param(value="searchname") String searchname,@Param(value="status") Integer status);
	
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	User selectByPwd(User record);

	int getUserCount(@Param(value="searchname") String searchname,@Param(value="status") Integer status);
}