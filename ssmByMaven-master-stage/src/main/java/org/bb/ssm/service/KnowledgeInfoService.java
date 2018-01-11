package org.bb.ssm.service;

import java.util.List;

import org.bb.ssm.model.Knowledge;

/**
 * Dao���Ǻ����ݿ�򽻵��ģ�Service����װ�����ҵ���е����.. e.g. �û�����ϵͳ
 * dao��װ���û�����ɾ�Ĳ顣��ҵ����Ҫ������ɾ���û���Service�Ϳ��Է�װ��һ������ɾ���û��Ĺ���
 * ������ʵ��ֻ��ѭ������dao�ĵ���ɾ��  
 * �˴�û�������ҵ���������Ժ�dao��д��һģһ��
 * 
 * @author Administrator
 *
 */
public interface KnowledgeInfoService {

	List<Knowledge> findAll();
	
	int deleteByPrimaryKey(Integer id);

	int insert(Knowledge record);

	int insertSelective(Knowledge record);

	Knowledge selectByPrimaryKey(Integer id);
	
	Knowledge selectByPwd(Knowledge record);

	int updateByPrimaryKeySelective(Knowledge record);

	int updateByPrimaryKey(Knowledge record);

	List<Knowledge> selectByCourseId(Integer id);
}
