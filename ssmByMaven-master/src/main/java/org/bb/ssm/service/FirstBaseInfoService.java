package org.bb.ssm.service;

import java.util.List;

import org.bb.ssm.model.FirstBase;
import org.bb.ssm.model.FirstBase;

/**
 * Dao���Ǻ����ݿ�򽻵��ģ�Service����װ�����ҵ���е����.. e.g. �û�����ϵͳ
 * dao��װ���û�����ɾ�Ĳ顣��ҵ����Ҫ������ɾ���û���Service�Ϳ��Է�װ��һ������ɾ���û��Ĺ���
 * ������ʵ��ֻ��ѭ������dao�ĵ���ɾ��  
 * �˴�û�������ҵ���������Ժ�dao��д��һģһ��
 * 
 * @author Administrator
 *
 */
public interface FirstBaseInfoService {

	List<FirstBase> findAll();
	
	int deleteByPrimaryKey(Integer id);

	int insert(FirstBase record);

	int insertSelective(FirstBase record);

	FirstBase selectByPrimaryKey(Integer id);
	
	FirstBase selectByPwd(FirstBase record);

	int updateByPrimaryKeySelective(FirstBase record);

	int updateByPrimaryKey(FirstBase record);

	int deleteByUserid(Integer user_id);

	int deleteByRoleid(Integer id);

	int bindmenu(FirstBase rolemenu);
}
