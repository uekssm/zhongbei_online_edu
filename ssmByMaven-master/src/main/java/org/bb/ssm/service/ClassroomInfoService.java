package org.bb.ssm.service;

import java.util.List;

import org.bb.ssm.model.Classroom;

/**
 * Dao���Ǻ����ݿ�򽻵��ģ�Service����װ�����ҵ���е����.. e.g. �û�����ϵͳ
 * dao��װ���û�����ɾ�Ĳ顣��ҵ����Ҫ������ɾ���û���Service�Ϳ��Է�װ��һ������ɾ���û��Ĺ���
 * ������ʵ��ֻ��ѭ������dao�ĵ���ɾ��  
 * �˴�û�������ҵ���������Ժ�dao��д��һģһ��
 * 
 * @author Administrator
 *
 */
public interface ClassroomInfoService {

	List<Classroom> findAll();
	
	int deleteByPrimaryKey(Integer id);

	int insert(Classroom record);

	int insertSelective(Classroom record);

	Classroom selectByPrimaryKey(Integer id);
	
	Classroom selectByPwd(Classroom record);

	int updateByPrimaryKeySelective(Classroom record);

	int updateByPrimaryKey(Classroom record);
}
