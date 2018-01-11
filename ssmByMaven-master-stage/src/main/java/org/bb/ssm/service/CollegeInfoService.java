package org.bb.ssm.service;

import java.util.List;

import org.bb.ssm.model.College;

/**
 * Dao���Ǻ����ݿ�򽻵��ģ�Service����װ�����ҵ���е����.. e.g. �û�����ϵͳ
 * dao��װ���û�����ɾ�Ĳ顣��ҵ����Ҫ������ɾ���û���Service�Ϳ��Է�װ��һ������ɾ���û��Ĺ���
 * ������ʵ��ֻ��ѭ������dao�ĵ���ɾ��  
 * �˴�û�������ҵ���������Ժ�dao��д��һģһ��
 * 
 * @author Administrator
 *
 */
public interface CollegeInfoService {

	List<College> findAll();
	
	int deleteByPrimaryKey(Integer id);

	int insert(College record);

	int insertSelective(College record);

	College selectByPrimaryKey(Integer id);
	
	College selectByPwd(College record);

	int updateByPrimaryKeySelective(College record);

	int updateByPrimaryKey(College record);
}
