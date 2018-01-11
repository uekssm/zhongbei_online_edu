package org.bb.ssm.mapper;

import java.util.List;

import org.bb.ssm.model.Boutique;

public interface BoutiqueInfoMapper {
	
	List<Boutique> findAll();
	
    int deleteByPrimaryKey(Integer BoutiqueId);

    int insert(Boutique record);

    int insertSelective(Boutique record);

    Boutique selectByPrimaryKey(Integer BoutiqueId);

    int updateByPrimaryKeySelective(Boutique record);

    int updateByPrimaryKey(Boutique record);

	Boutique selectByPwd(Boutique record);
}