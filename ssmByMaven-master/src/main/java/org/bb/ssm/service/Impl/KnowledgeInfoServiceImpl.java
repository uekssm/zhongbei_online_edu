package org.bb.ssm.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.bb.ssm.mapper.KnowledgeInfoMapper;
import org.bb.ssm.model.Knowledge;
import org.bb.ssm.service.KnowledgeInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//��������xml�ж�bean������
@Service
// �˴�ʹ��spring������ʽ���񣬲���ʹ��sqlsession���ύ������
@Transactional
public class KnowledgeInfoServiceImpl implements KnowledgeInfoService {

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
	private KnowledgeInfoMapper mapper;

	/**
	 * ��ѯKnowledgeInfo����������
	 */
	@Override
	public List<Knowledge> findAll() {
		List<Knowledge> list = mapper.findAll();
		return list;
	}
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Knowledge record) {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(Knowledge record) {
		return mapper.insertSelective(record);
	}

	@Override
	public Knowledge selectByPrimaryKey(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Knowledge record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Knowledge record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public Knowledge selectByPwd(Knowledge record) {
		// TODO Auto-generated method stub
		return mapper.selectByPwd(record);
	}

}
