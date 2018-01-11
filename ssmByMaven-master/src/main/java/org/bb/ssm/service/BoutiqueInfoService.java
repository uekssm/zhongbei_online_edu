package org.bb.ssm.service;

import java.util.List;

import org.bb.ssm.model.Boutique;

/**
 * Dao���Ǻ����ݿ�򽻵��ģ�Service����װ�����ҵ���е����.. e.g. �û�����ϵͳ
 * dao��װ���û�����ɾ�Ĳ顣��ҵ����Ҫ������ɾ���û���Service�Ϳ��Է�װ��һ������ɾ���û��Ĺ���
 * ������ʵ��ֻ��ѭ������dao�ĵ���ɾ��  
 * �˴�û�������ҵ���������Ժ�dao��д��һģһ��
 * 
 * @author Administrator
 *
 */
public interface BoutiqueInfoService {

	List<Boutique> findAll();
	
	int deleteByPrimaryKey(Integer id);

	int insert(Boutique record);

	int insertSelective(Boutique record);

	Boutique selectByPrimaryKey(Integer id);
	
	Boutique selectByPwd(Boutique record);

	int updateByPrimaryKeySelective(Boutique record);

	int updateByPrimaryKey(Boutique record);
}
