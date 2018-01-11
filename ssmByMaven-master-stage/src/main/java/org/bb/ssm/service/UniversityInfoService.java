package org.bb.ssm.service;

import java.util.List;

import org.bb.ssm.model.University;

/**
 * Dao���Ǻ����ݿ�򽻵��ģ�Service����װ�����ҵ���е����.. e.g. �û�����ϵͳ
 * dao��װ���û�����ɾ�Ĳ顣��ҵ����Ҫ������ɾ���û���Service�Ϳ��Է�װ��һ������ɾ���û��Ĺ���
 * ������ʵ��ֻ��ѭ������dao�ĵ���ɾ��  
 * �˴�û�������ҵ���������Ժ�dao��д��һģһ��
 * 
 * @author Administrator
 *
 */
public interface UniversityInfoService {

	List<University> findAll();
	
	int deleteByPrimaryKey(Integer id);

	int insert(University record);

	int insertSelective(University record);

	University selectByPrimaryKey(Integer id);
	
	University selectByPwd(University record);

	int updateByPrimaryKeySelective(University record);

	int updateByPrimaryKey(University record);
}
