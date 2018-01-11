package org.bb.ssm.service;

import java.util.List;

import org.bb.ssm.model.Indicators;

/**
 * Dao���Ǻ����ݿ�򽻵��ģ�Service����װ�����ҵ���е����.. e.g. �û�����ϵͳ
 * dao��װ���û�����ɾ�Ĳ顣��ҵ����Ҫ������ɾ���û���Service�Ϳ��Է�װ��һ������ɾ���û��Ĺ���
 * ������ʵ��ֻ��ѭ������dao�ĵ���ɾ��  
 * �˴�û�������ҵ���������Ժ�dao��д��һģһ��
 * 
 * @author Administrator
 *
 */
public interface IndicatorsInfoService {

	List<Indicators> findAll();
	
	int deleteByPrimaryKey(Integer id);

	int insert(Indicators record);

	int insertSelective(Indicators record);

	Indicators selectByPrimaryKey(Integer id);
	
	Indicators selectByPwd(Indicators record);

	int updateByPrimaryKeySelective(Indicators record);

	int updateByPrimaryKey(Indicators record);
}
