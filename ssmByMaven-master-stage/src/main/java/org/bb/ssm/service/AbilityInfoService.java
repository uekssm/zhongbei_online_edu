package org.bb.ssm.service;

import java.util.List;

import org.bb.ssm.model.Ability;

/**
 * Dao���Ǻ����ݿ�򽻵��ģ�Service����װ�����ҵ���е����.. e.g. �û�����ϵͳ
 * dao��װ���û�����ɾ�Ĳ顣��ҵ����Ҫ������ɾ���û���Service�Ϳ��Է�װ��һ������ɾ���û��Ĺ���
 * ������ʵ��ֻ��ѭ������dao�ĵ���ɾ��  
 * �˴�û�������ҵ���������Ժ�dao��д��һģһ��
 * 
 * @author Administrator
 *
 */
public interface AbilityInfoService {

	List<Ability> findAll();
	
	int deleteByPrimaryKey(Integer id);

	int insert(Ability record);

	int insertSelective(Ability record);

	Ability selectByPrimaryKey(Integer id);
	
	Ability selectByPwd(Ability record);

	int updateByPrimaryKeySelective(Ability record);

	int updateByPrimaryKey(Ability record);
}
