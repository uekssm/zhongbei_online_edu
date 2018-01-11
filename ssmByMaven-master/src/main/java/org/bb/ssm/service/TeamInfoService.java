package org.bb.ssm.service;

import java.util.List;

import org.bb.ssm.model.Team;

/**
 * Dao���Ǻ����ݿ�򽻵��ģ�Service����װ�����ҵ���е����.. e.g. �û�����ϵͳ
 * dao��װ���û�����ɾ�Ĳ顣��ҵ����Ҫ������ɾ���û���Service�Ϳ��Է�װ��һ������ɾ���û��Ĺ���
 * ������ʵ��ֻ��ѭ������dao�ĵ���ɾ��  
 * �˴�û�������ҵ���������Ժ�dao��д��һģһ��
 * 
 * @author Administrator
 *
 */
public interface TeamInfoService {

	List<Team> findAll();
	
	int deleteByPrimaryKey(Integer id);

	int insert(Team record);

	int insertSelective(Team record);

	Team selectByPrimaryKey(Integer id);
	
	Team selectByPwd(Team record);

	int updateByPrimaryKeySelective(Team record);

	int updateByPrimaryKey(Team record);
}
