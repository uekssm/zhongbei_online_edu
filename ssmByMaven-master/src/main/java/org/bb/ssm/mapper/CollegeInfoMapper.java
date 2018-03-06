package org.bb.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.bb.ssm.model.College;

public interface CollegeInfoMapper {
	
	List<College> findAll(@Param(value="limit") Integer limit,@Param(value="pageIndex") Integer pageIndex,@Param(value="name") String name,@Param(value="university_id") int university_id);
	
    int deleteByPrimaryKey(Integer CollegeId);

    int insert(College record);

    int insertSelective(College record);

    College selectByPrimaryKey(Integer CollegeId);

    int updateByPrimaryKeySelective(College record);

    int updateByPrimaryKey(College record);

	College selectByPwd(College record);

	List<College> findAllCollege();

	int getCollegeCount(@Param(value="name") String name,@Param(value="university_id") int university_id);
}