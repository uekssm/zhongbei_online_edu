package org.bb.ssm.service;

import java.util.List;

import org.bb.ssm.model.ResourceManager;

/**
 * Dao���Ǻ����ݿ�򽻵��ģ�Service����װ�����ҵ���е����.. e.g. �û�����ϵͳ
 * dao��װ���û�����ɾ�Ĳ顣��ҵ����Ҫ������ɾ���û���Service�Ϳ��Է�װ��һ������ɾ���û��Ĺ���
 * ������ʵ��ֻ��ѭ������dao�ĵ���ɾ��  
 * �˴�û�������ҵ���������Ժ�dao��д��һģһ��
 * 
 * @author Administrator
 *
 */
public interface ResourceManagerInfoService {

	List<ResourceManager> findAll(Integer limit, Integer pageIndex, String searchname, Integer pid);
	
	int deleteByPrimaryKey(Integer id);

	int insert(ResourceManager record);

	int insertSelective(ResourceManager record);

	ResourceManager selectByPrimaryKey(Integer id);
	
	ResourceManager selectByPwd(ResourceManager record);

	int updateByPrimaryKeySelective(ResourceManager record);

	int updateByPrimaryKey(ResourceManager record);

	int totalCount(String searchname, Integer pid);

	List<ResourceManager> finddir();
}
