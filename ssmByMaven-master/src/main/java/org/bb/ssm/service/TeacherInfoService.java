package org.bb.ssm.service;

import java.util.List;

import org.bb.ssm.model.Teacher;

/**
 * Dao���Ǻ����ݿ�򽻵��ģ�Service����װ�����ҵ���е����.. e.g. �û�����ϵͳ
 * dao��װ���û�����ɾ�Ĳ顣��ҵ����Ҫ������ɾ���û���Service�Ϳ��Է�װ��һ������ɾ���û��Ĺ���
 * ������ʵ��ֻ��ѭ������dao�ĵ���ɾ��  
 * �˴�û�������ҵ���������Ժ�dao��д��һģһ��
 * 
 * @author Administrator
 *
 */
public interface TeacherInfoService {

	List<Teacher> findAll();
	
	int deleteByPrimaryKey(Integer id);

	int insert(Teacher record);

	int insertSelective(Teacher record);

	Teacher selectByPrimaryKey(Integer id);
	
	Teacher selectByPwd(Teacher record);

	int updateByPrimaryKeySelective(Teacher record);

	int updateByPrimaryKey(Teacher record);
}
