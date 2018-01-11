package org.bb.ssm.service;

import java.util.List;

import org.bb.ssm.model.Direction;

/**
 * Dao���Ǻ����ݿ�򽻵��ģ�Service����װ�����ҵ���е����.. e.g. �û�����ϵͳ
 * dao��װ���û�����ɾ�Ĳ顣��ҵ����Ҫ������ɾ���û���Service�Ϳ��Է�װ��һ������ɾ���û��Ĺ���
 * ������ʵ��ֻ��ѭ������dao�ĵ���ɾ��  
 * �˴�û�������ҵ���������Ժ�dao��д��һģһ��
 * 
 * @author Administrator
 *
 */
public interface DirectionInfoService {

	List<Direction> findAll();
	
	int deleteByPrimaryKey(Integer id);

	int insert(Direction record);

	int insertSelective(Direction record);

	Direction selectByPrimaryKey(Integer id);
	
	Direction selectByPwd(Direction record);

	int updateByPrimaryKeySelective(Direction record);

	int updateByPrimaryKey(Direction record);
}
