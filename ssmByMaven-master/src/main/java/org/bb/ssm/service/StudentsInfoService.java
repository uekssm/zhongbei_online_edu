package org.bb.ssm.service;

import java.util.List;

import org.bb.ssm.model.Students;

/**
 * Dao���Ǻ����ݿ�򽻵��ģ�Service����װ�����ҵ���е����.. e.g. �û�����ϵͳ
 * dao��װ���û�����ɾ�Ĳ顣��ҵ����Ҫ������ɾ���û���Service�Ϳ��Է�װ��һ������ɾ���û��Ĺ���
 * ������ʵ��ֻ��ѭ������dao�ĵ���ɾ��  
 * �˴�û�������ҵ���������Ժ�dao��д��һģһ��
 * 
 * @author Administrator
 *
 */
public interface StudentsInfoService {

	List<Students> findAll();
	
	int deleteByPrimaryKey(Integer id);

	int insert(Students record);

	int insertSelective(Students record);

	Students selectByPrimaryKey(Integer id);
	
	Students selectByPwd(Students record);

	int updateByPrimaryKeySelective(Students record);

	int updateByPrimaryKey(Students record);
}
