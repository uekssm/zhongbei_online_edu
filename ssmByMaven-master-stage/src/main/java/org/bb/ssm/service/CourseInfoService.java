package org.bb.ssm.service;

import java.util.List;

import org.bb.ssm.model.Course;

/**
 * Dao���Ǻ����ݿ�򽻵��ģ�Service����װ�����ҵ���е����.. e.g. �û�����ϵͳ
 * dao��װ���û�����ɾ�Ĳ顣��ҵ����Ҫ������ɾ���û���Service�Ϳ��Է�װ��һ������ɾ���û��Ĺ���
 * ������ʵ��ֻ��ѭ������dao�ĵ���ɾ��  
 * �˴�û�������ҵ���������Ժ�dao��д��һģһ��
 * 
 * @author Administrator
 *
 */
public interface CourseInfoService {

	List<Course> findAll();
	
	int deleteByPrimaryKey(Integer id);

	int insert(Course record);

	int insertSelective(Course record);

	Course selectByPrimaryKey(Integer id);
	
	Course selectByPwd(Course record);

	int updateByPrimaryKeySelective(Course record);

	int updateByPrimaryKey(Course record);

	Object selectByCourseId(Integer id);
}
