package org.bb.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.bb.ssm.model.Menu;

public interface MenuInfoMapper {
	
	List<Menu> findAll();
	
    int deleteByPrimaryKey(Integer userId);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

	List<Menu> findOne();
	
	List<Menu> findPage();

	int getMenuCount(@Param(value="searchname") String searchname,@Param(value="url") String url);

	List<Menu> findAllByPage(@Param(value="limit") Integer limit,@Param(value="pageIndex") Integer pageIndex,@Param(value="searchname") String searchname,@Param(value="url") String url);
}