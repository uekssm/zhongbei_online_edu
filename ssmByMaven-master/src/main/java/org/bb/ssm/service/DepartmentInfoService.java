package org.bb.ssm.service;

import java.util.List;

import org.bb.ssm.model.Department;

/**
 * Dao���Ǻ����ݿ�򽻵��ģ�Service����װ�����ҵ���е����.. e.g. �û�����ϵͳ
 * dao��װ���û�����ɾ�Ĳ顣��ҵ����Ҫ������ɾ���û���Service�Ϳ��Է�װ��һ������ɾ���û��Ĺ���
 * ������ʵ��ֻ��ѭ������dao�ĵ���ɾ��  
 * �˴�û�������ҵ���������Ժ�dao��д��һģһ��
 * 
 * @author Administrator
 *
 */
public interface DepartmentInfoService {

	List<Department> findAll();
	
	int deleteByPrimaryKey(Integer id);

	int insert(Department record);

	int insertSelective(Department record);

	Department selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Department record);

	int updateByPrimaryKey(Department record);

	List<Department> findOne();
	
	List<Department> findPage();
}
