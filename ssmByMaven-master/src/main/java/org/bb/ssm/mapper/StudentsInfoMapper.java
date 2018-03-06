package org.bb.ssm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.bb.ssm.model.Students;

public interface StudentsInfoMapper {
	
	List<Students> findAll(@Param(value="limit") Integer limit,@Param(value="pageIndex") Integer pageIndex,@Param(value="searchname") String searchname);
	
    int deleteByPrimaryKey(Integer StudentsId);

    int insert(Students record);

    int insertSelective(Students record);

    Students selectByPrimaryKey(Integer StudentsId);

    int updateByPrimaryKeySelective(Students record);

    int updateByPrimaryKey(Students record);

	Students selectByPwd(Students record);

	int insertMore(@Param("data") List<Map<String, String>> data);

	int countStu(@Param(value="searchname") String searchname);
}