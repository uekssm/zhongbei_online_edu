package org.bb.ssm.service;

import java.util.List;

import org.bb.ssm.model.Position;

/**
 * Dao���Ǻ����ݿ�򽻵��ģ�Service����װ�����ҵ���е����.. e.g. �û�����ϵͳ
 * dao��װ���û�����ɾ�Ĳ顣��ҵ����Ҫ������ɾ���û���Service�Ϳ��Է�װ��һ������ɾ���û��Ĺ���
 * ������ʵ��ֻ��ѭ������dao�ĵ���ɾ��  
 * �˴�û�������ҵ���������Ժ�dao��д��һģһ��
 * 
 * @author Administrator
 *
 */
public interface PositionInfoService {

	List<Position> findAll();
	
	int deleteByPrimaryKey(Integer id);

	int insert(Position record);

	int insertSelective(Position record);

	Position selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Position record);

	int updateByPrimaryKey(Position record);

	List<Position> findOne();
	
	List<Position> findPage();
}
