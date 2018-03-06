package org.bb.ssm.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.bb.ssm.mapper.ResourceManagerInfoMapper;
import org.bb.ssm.model.ResourceManager;
import org.bb.ssm.service.ResourceManagerInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//��������xml�ж�bean������
@Service
// �˴�ʹ��spring������ʽ���񣬲���ʹ��sqlsession���ύ������
@Transactional
public class ResourceManagerInfoServiceImpl implements ResourceManagerInfoService {

	@Resource
	/**
	 * @Resource�������൱��@Autowired��ֻ����@Autowired��byType�Զ�ע�룬
	 * ��@ResourceĬ�ϰ� byName�Զ�ע����ˡ�@Resource�����������ǱȽ���Ҫ�ģ�
	 * ����name��type��Spring��@Resourceע���name���Խ���Ϊbean�����֣�
	 * ��type���������Ϊbean�����͡��������ʹ��name���ԣ���ʹ��byName���Զ�ע����ԣ�
	 * ��ʹ��type����ʱ��ʹ��byType�Զ�ע����ԡ�����Ȳ�ָ��nameҲ��ָ��type���ԣ�
	 * ��ʱ��ͨ���������ʹ��byName�Զ�ע����ԡ� @Resourceװ��˳��
	 *                                                                  
	 *1.���ͬʱָ����name��type�����Spring���������ҵ�Ψһƥ���bean����װ�䣬�Ҳ������׳��쳣
	 *2.
	 *���ָ����name������������в������ƣ�id��ƥ���bean����װ�䣬�Ҳ������׳��쳣
	 *3.
	 *���ָ����type��������������ҵ�����ƥ���Ψһbean����װ�䣬�Ҳ��������ҵ�����������׳��쳣
	 *4.
	 *�����û��ָ��name����û��ָ��type�����Զ�����byName��ʽ����װ�䣻���û��ƥ�䣬�����Ϊһ��ԭʼ���ͽ���ƥ�䣬���ƥ�����Զ�װ�䣻
	 */
	private ResourceManagerInfoMapper mapper;

	
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(ResourceManager record) {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(ResourceManager record) {
		return mapper.insertSelective(record);
	}

	@Override
	public ResourceManager selectByPrimaryKey(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(ResourceManager record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(ResourceManager record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public ResourceManager selectByPwd(ResourceManager record) {
	
		return mapper.selectByPwd(record);
	}

	@Override
	public List<ResourceManager> findAll(Integer limit, Integer pageIndex,
			String searchname,Integer pid) {
		List<ResourceManager> list = mapper.findAll(limit,pageIndex,searchname,pid);
		return list;
	}

	@Override
	public int totalCount(String searchname,Integer pid) {
		return (int) mapper.getResourceManagerCount(searchname,pid);
	}

	@Override
	public List<ResourceManager> finddir() {
		List<ResourceManager> list = mapper.finddir();
		return list;
	}

}
