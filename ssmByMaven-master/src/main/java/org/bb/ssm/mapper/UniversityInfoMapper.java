package org.bb.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.bb.ssm.model.University;

public interface UniversityInfoMapper {
	
	/** 
	 * 使用注解方式传入多个参数，用户产品分页，通过登录用户ID查询 
	 * @param page 
	 * @param userId 
	 * @return startPos},#{pageSize}  
	 */  
	public List<University> selectUniversitysByPage(@Param(value="startPos") Integer startPos,@Param(value="pageSize") Integer pageSize);  
	  
	/** 
	 * 取得产品数量信息，通过登录用户ID查询 
	 * @param userId 
	 * @return 
	 */  
	
	public long getUniversitysCount(@Param(value="searchname") String searchname);  
	
	
	List<University> findAll(@Param(value="limit") Integer limit,@Param(value="pageIndex") Integer pageIndex,@Param(value="searchname") String searchname);
	
    int deleteByPrimaryKey(@Param(value="ids") String[] ids);

    int insert(University record);

    int insertSelective(University record);

    University selectByPrimaryKey(Integer UniversityId);

    int updateByPrimaryKeySelective(University record);

    int updateByPrimaryKey(University record);

	University selectByPwd(University record);
}