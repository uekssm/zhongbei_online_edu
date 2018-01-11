package org.bb.ssm.mapper;

import java.util.List;

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
}