package org.bb.ssm.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.bb.ssm.mapper.EmployeeInfoMapper;
import org.bb.ssm.model.Employee;
import org.bb.ssm.service.EmployeeInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//��������xml�ж�bean������
@Service
// �˴�ʹ��spring������ʽ���񣬲���ʹ��sqlsession���ύ������
@Transactional
public class EmployeeInfoServiceImpl implements EmployeeInfoService {

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
	private EmployeeInfoMapper mapper;

	/**
	 * ��ѯEmployeeInfo����������
	 */
	@Override
	public List<Employee> findAll() {
		List<Employee> list = mapper.findAll();
		return list;
	}
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Employee record) {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(Employee record) {
		return mapper.insertSelective(record);
	}

	@Override
	public Employee selectByPrimaryKey(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Employee record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Employee record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Employee> findOne() {
		List<Employee> list = mapper.findOne();
		return list;
	}

	@Override
	public List<Employee> findPage() {
		List<Employee> list = mapper.findPage();
		return list;
	}

}
