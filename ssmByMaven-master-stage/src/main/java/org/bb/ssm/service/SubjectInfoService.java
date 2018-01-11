package org.bb.ssm.service;

import java.util.List;

import org.bb.ssm.model.Subject;

/**
 * Dao���Ǻ����ݿ�򽻵��ģ�Service����װ�����ҵ���е����.. e.g. �û�����ϵͳ
 * dao��װ���û�����ɾ�Ĳ顣��ҵ����Ҫ������ɾ���û���Service�Ϳ��Է�װ��һ������ɾ���û��Ĺ���
 * ������ʵ��ֻ��ѭ������dao�ĵ���ɾ��  
 * �˴�û�������ҵ���������Ժ�dao��д��һģһ��
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
}
