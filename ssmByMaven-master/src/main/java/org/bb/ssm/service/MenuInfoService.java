package org.bb.ssm.service;

import java.util.List;

import org.bb.ssm.model.Menu;

/**
 * Dao���Ǻ����ݿ�򽻵��ģ�Service����װ�����ҵ���е����.. e.g. �û�����ϵͳ
 * dao��װ���û�����ɾ�Ĳ顣��ҵ����Ҫ������ɾ���û���Service�Ϳ��Է�װ��һ������ɾ���û��Ĺ���
 * ������ʵ��ֻ��ѭ������dao�ĵ���ɾ��  
 * �˴�û�������ҵ���������Ժ�dao��д��һģһ��
 * 
 * @author Administrator
 *
 */
public interface MenuInfoService {

	List<Menu> findAll();
	
	int deleteByPrimaryKey(Integer id);

	int insert(Menu record);

	int insertSelective(Menu record);

	Menu selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Menu record);

	int updateByPrimaryKey(Menu record);

	List<Menu> findOne();
	
	List<Menu> findPage();
}
