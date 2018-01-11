package org.bb.ssm.service;

import java.util.List;

import org.bb.ssm.model.Class;

/**
 * Dao���Ǻ����ݿ�򽻵��ģ�Service����װ�����ҵ���е����.. e.g. �û�����ϵͳ
 * dao��װ���û�����ɾ�Ĳ顣��ҵ����Ҫ������ɾ���û���Service�Ϳ��Է�װ��һ������ɾ���û��Ĺ���
 * ������ʵ��ֻ��ѭ������dao�ĵ���ɾ��  
 * �˴�û�������ҵ���������Ժ�dao��д��һģһ��
 * 
 * @author Administrator
 *
 */
public interface ClassInfoService {

	List<Class> findAll();
	
	int deleteByPrimaryKey(Integer id);

	int insert(Class record);

	int insertSelective(Class record);

	Class selectByPrimaryKey(Integer id);
	
	Class selectByPwd(Class record);

	int updateByPrimaryKeySelective(Class record);

	int updateByPrimaryKey(Class record);
}
