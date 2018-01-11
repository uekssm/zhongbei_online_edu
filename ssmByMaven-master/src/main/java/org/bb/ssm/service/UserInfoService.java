package org.bb.ssm.service;

import java.util.List;

import org.bb.ssm.model.User;

/**
 * Dao���Ǻ����ݿ�򽻵��ģ�Service����װ�����ҵ���е����.. e.g. �û�����ϵͳ
 * dao��װ���û�����ɾ�Ĳ顣��ҵ����Ҫ������ɾ���û���Service�Ϳ��Է�װ��һ������ɾ���û��Ĺ���
 * ������ʵ��ֻ��ѭ������dao�ĵ���ɾ��  
 * �˴�û�������ҵ���������Ժ�dao��д��һģһ��
 * 
 * @author Administrator
 *
 */
public interface UserInfoService {

	List<User> findAll();
	
	int deleteByPrimaryKey(Integer id);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer id);
	
	User selectByPwd(User record);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);
}
