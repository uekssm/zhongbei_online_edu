package org.bb.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.bb.ssm.model.University;

public interface UniversityInfoMapper {
	
	/** 
	 * ʹ��ע�ⷽʽ�������������û���Ʒ��ҳ��ͨ����¼�û�ID��ѯ 
	 * @param page 
	 * @param userId 
	 * @return startPos},#{pageSize}  
	 */  
	public List<University> selectUniversitysByPage(@Param(value="startPos") Integer startPos,@Param(value="pageSize") Integer pageSize);  
	  
	/** 
	 * ȡ�ò�Ʒ������Ϣ��ͨ����¼�û�ID��ѯ 
	 * @param userId 
	 * @return 
	 */  
	
	public long getUniversitysCount(@Param(value="searchname") String searchname);  
	
	
	List<University> findAll(@Param(value="limit") Integer limit,@Param(value="pageIndex") Integer pageIndex,@Param(value="searchname") String searchname);
	
    int deleteByPrimaryKey(@Param(value="ids") String[] ids);

    int insert(University record);

    int insertSelective(University record);

    University selectByPrimaryKey(Integer UniversityId);

    int updateByPrimaryKeySelective(University record);

    int updateByPrimaryKey(University record);

	University selectByPwd(University record);
}