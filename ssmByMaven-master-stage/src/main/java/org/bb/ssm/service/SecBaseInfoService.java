package org.bb.ssm.service;

import java.util.List;

import org.bb.ssm.model.SecBase;
import org.bb.ssm.model.SecBase;

/**
 * Dao���Ǻ����ݿ�򽻵��ģ�Service����װ�����ҵ���е����.. e.g. �û�����ϵͳ
 * dao��װ���û�����ɾ�Ĳ顣��ҵ����Ҫ������ɾ���û���Service�Ϳ��Է�װ��һ������ɾ���û��Ĺ���
 * ������ʵ��ֻ��ѭ������dao�ĵ���ɾ��  
 * �˴�û�������ҵ���������Ժ�dao��д��һģһ��
 * 
 * @author Administrator
 *
 */
public interface SecBaseInfoService {

	List<SecBase> findAll();
	
	int deleteByPrimaryKey(Integer id);

	int insert(SecBase videorecord);

	int insertSelective(SecBase record);

	SecBase selectByPrimaryKey(Integer id);
	
	SecBase selectByPwd(SecBase record);

	int updateByPrimaryKeySelective(SecBase record);

	int updateByPrimaryKey(SecBase record);

	String findtimeByUserid(Integer user_id);

	void deleteByUserid(Integer user_id);
}
