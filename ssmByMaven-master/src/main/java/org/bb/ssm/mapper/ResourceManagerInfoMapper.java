package org.bb.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.bb.ssm.model.ResourceManager;

public interface ResourceManagerInfoMapper {
	
	List<ResourceManager> findAll(@Param(value="limit") Integer limit,@Param(value="pageIndex") Integer pageIndex,@Param(value="searchname") String searchname,@Param(value="pid") Integer pid);
	
    int deleteByPrimaryKey(Integer userId);

    int insert(ResourceManager record);

    int insertSelective(ResourceManager record);

    ResourceManager selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(ResourceManager record);

    int updateByPrimaryKey(ResourceManager record);

	ResourceManager selectByPwd(ResourceManager record);

	int getResourceManagerCount(@Param(value="searchname") String searchname,@Param(value="pid") Integer pid);

	List<ResourceManager> finddir();
}