package org.bb.ssm.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.bb.ssm.model.University;
import org.springframework.ui.Model;

/**
 * Dao���Ǻ����ݿ�򽻵��ģ�Service����װ�����ҵ���е����.. e.g. �û�����ϵͳ
 * dao��װ���û�����ɾ�Ĳ顣��ҵ����Ҫ������ɾ���û���Service�Ϳ��Է�װ��һ������ɾ���û��Ĺ���
 * ������ʵ��ֻ��ѭ������dao�ĵ���ɾ��  
 * �˴�û�������ҵ���������Ժ�dao��д��һģһ��
 * 
 * @author Administrator
 *
 */
public interface UniversityInfoService {

	
    
	List<University> findAll(int limit, int pageIndex, String searchname);
	
	int totalCount(String searchname);// = (int) mapper.getUniversitysCount(); 
	
	int deleteByPrimaryKey(String[] ids);

	int insert(University record);

	int insertSelective(University record);

	University selectByPrimaryKey(Integer id);
	
	University selectByPwd(University record);

	int updateByPrimaryKeySelective(University record);

	int updateByPrimaryKey(University record);
}
