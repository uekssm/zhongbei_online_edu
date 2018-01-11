package org.bb.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bb.ssm.model.Employee;
import org.bb.ssm.service.EmployeeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping(value="/employee")
public class EmployeeInfoCotroller {
	
	@Autowired
	private EmployeeInfoService employeeInfoService;
	
	/**
	 * �û��б�ҳ
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(Map<String, Object> map){
		//List<employee> employeeList = employeeInfoService.findAll();
		//map.put("ALLemployee", employeeList);
		return "bui/organization/employeeList";
	}
	
	/**
	 * �õ������û���Ϣ
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/getAllEmployee",method=RequestMethod.POST)
	@ResponseBody
	public String getAllEmployee(Object pageinfo,Map<String, Object> map){
		System.out.println(pageinfo);
		List<Employee> employeeList = employeeInfoService.findAll();
		
		HashMap<String,Object > temployee = new HashMap<String,Object >();
		
		temployee.put("rows", employeeList);
		temployee.put("results", employeeList.size());
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsondata = mapper.writeValueAsString(temployee);

			//System.out.println(jsondata);
			
			return jsondata;
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * ͨ��handlerǰ������û�ҳ��
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/addemployee",method= RequestMethod.GET)
	public String addemployee(Map<String, Object> map){
		//��Ϊҳ��ʹ��spring��form��ǩ����������modelAttribute��Ҫ����bean Ҫ���ᱨ��
		map.put("command", new Employee());
		return "addemployee";
	}
	
	/**
	 * ����û�����
	 * @param employeeinfo
	 * @return
	 */
	@RequestMapping(value="/addemployee",method=RequestMethod.POST)
	public String save(Employee employeeinfo){
		int result = employeeInfoService.insert(employeeinfo);
		System.out.println("����û��Ĳ������Ϊ��"+result);
		return "redirect:/employee/getAllEmployee";
	}
	/**
	 * ɾ���û�����
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable(value="id") int id){
		int result = employeeInfoService.deleteByPrimaryKey(id);
		System.out.println("ɾ���û��Ĳ������Ϊ��"+result+"���ݽ�����idΪ��"+id);
		return "redirect:/employee/getAllEmployee";
	}
	/**
	 * ����ǰ�ȸ���id�ҵ��û���Ϣ�����Ե�ҳ����
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/detail/{id}",method=RequestMethod.GET)
	public String input(@PathVariable(value="id") Integer id,Map<String, Object> map){
		map.put("command", employeeInfoService.selectByPrimaryKey(id));
		return "addemployee";
	}
	
	@ModelAttribute
	public void getemployeeInfo(@RequestParam(value="employeeId",required=false) Integer id
			,Map<String, Object> map){
		System.out.println("ÿ��controller ���������ȵ�����Ŷ");
		if(id != null){
			System.out.println("update ����");
			map.put("employeeInfo", employeeInfoService.selectByPrimaryKey(id));
		}
		System.out.println("insert  ����");
	}
	
	@RequestMapping(value="/addemployee",method=RequestMethod.PUT)
	public String update(Employee employeeinfo){
		employeeInfoService.updateByPrimaryKey(employeeinfo);
		return "redirect:/employee/getAllEmployee";
	}
}
