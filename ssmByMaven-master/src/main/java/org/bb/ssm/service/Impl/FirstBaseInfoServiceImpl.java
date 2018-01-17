package org.bb.ssm.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.bb.ssm.mapper.FirstBaseInfoMapper;
import org.bb.ssm.model.FirstBase;
import org.bb.ssm.service.FirstBaseInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//��������xml�ж�bean������
@Service
// �˴�ʹ��spring������ʽ���񣬲���ʹ��sqlsession���ύ������
@Transactional
public class FirstBaseInfoServiceImpl implements FirstBaseInfoService {

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
	private FirstBaseInfoMapper mapper;

	/**
	 * ��ѯFirstBaseInfo����������
	 */
	@Override
	public List<FirstBase> findAll() {
		List<FirstBase> list = mapper.findAll();
		return list;
	}
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(FirstBase record) {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(FirstBase record) {
		return mapper.insertSelective(record);
	}

	@Override
	public FirstBase selectByPrimaryKey(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(FirstBase record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(FirstBase record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public FirstBase selectByPwd(FirstBase record) {
	
		return mapper.selectByPwd(record);
	}

	@Override
	public int deleteByUserid(Integer user_id) {
		return mapper.deleteByUserid(user_id);
	}

	@Override
	public int deleteByRoleid(Integer id) {
		return mapper.deleteByRoleid(id);
	}

	@Override
	public int bindmenu(FirstBase rolemenu) {
		return mapper.bindmenu(rolemenu);
	}

}
