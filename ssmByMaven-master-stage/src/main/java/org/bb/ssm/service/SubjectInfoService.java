package org.bb.ssm.service;

import java.util.List;

import org.bb.ssm.model.Subject;

/**
 * Dao层是和数据库打交道的，Service层会封装具体的业务。有点抽象.. e.g. 用户管理系统
 * dao封装了用户的增删改查。而业务上要求批量删除用户，Service就可以封装出一个批量删除用户的功能
 * ，但是实现只是循环调用dao的单个删除  
 * 此处没有特殊的业务需求，所以和dao层写的一模一样
 * 
 * @author Administrator
 *
 */
public interface SubjectInfoService {

	List<Subject> findAll();
	
	int deleteByPrimaryKey(Integer id);

	int insert(Subject record);

	int insertSelective(Subject record);

	Subject selectByPrimaryKey(Integer id);
	
	Subject selectByPwd(Subject record);

	int updateByPrimaryKeySelective(Subject record);

	int updateByPrimaryKey(Subject record);

	List<Subject> findAllMajor(int collegeId);
}
