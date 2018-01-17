package org.bb.ssm.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bb.ssm.model.Employee;
import org.bb.ssm.model.FirstBase;
import org.bb.ssm.model.User;
import org.bb.ssm.service.EmployeeInfoService;
import org.bb.ssm.service.FirstBaseInfoService;
import org.bb.ssm.service.PositionInfoService;
import org.bb.ssm.service.UserInfoService;
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
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private FirstBaseInfoService firstBaseInfoService;
	
	@Autowired
	private PositionInfoService positionInfoService;
	
	/**
	 * Ա���б�ҳ
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
	 * �õ�����Ա����Ϣ
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/getAllEmployee",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String getAllEmployee(@RequestParam(value="limit",required=false) Integer limit,@RequestParam(value="pageIndex",required=false) Integer pageIndex,@RequestParam(value="searchname",required=false) String searchname,@RequestParam(value="position_id",required=false) Integer position_id){
		pageIndex=pageIndex*limit;
		List<Employee> employeeList = employeeInfoService.findAll(limit,pageIndex,searchname,position_id);
		
		HashMap<String,Object > temployee = new HashMap<String,Object >();
		
		temployee.put("rows", employeeList);
		temployee.put("results", employeeInfoService.totalCount(searchname,position_id));
		
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
	 * ͨ��handlerǰ�����Ա��ҳ��
	 * @param map
	 * @return
	 */
	/*@RequestMapping(value="/addemployee",method= RequestMethod.GET)
	public String addemployee(Map<String, Object> map){
		//��Ϊҳ��ʹ��spring��form��ǩ����������modelAttribute��Ҫ����bean Ҫ���ᱨ��
		map.put("command", new Employee());
		return "addemployee";
	}*/
	
	/**
	 * ���Ա������
	 * @param employeeinfo
	 * @return
	 */
	@RequestMapping(value="/addemployee")
	public String save(Employee employeeinfo){
		//����Ա��֮ǰ������û�
		User userinfo=new User();
		userinfo.setUsername(employeeinfo.getName());
		
		try {
			String pwd="111111";
	        // ����һ��MD5���ܼ���ժҪ
	        MessageDigest md;
			md = MessageDigest.getInstance("MD5");
			 // ����md5����
	        md.update(pwd.getBytes());
	        // digest()���ȷ������md5 hashֵ������ֵΪ8Ϊ�ַ�������Ϊmd5 hashֵ��16λ��hexֵ��ʵ���Ͼ���8λ���ַ�
	        // BigInteger������8λ���ַ���ת����16λhexֵ�����ַ�������ʾ���õ��ַ�����ʽ��hashֵ
	        String md5pwd=new BigInteger(1, md.digest()).toString(16);
	        userinfo.setPassword(md5pwd);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		userinfo.setStatus(1);
		userInfoService.insert(userinfo);
		employeeinfo.setUser_id(userinfo.getId());
		int result = employeeInfoService.insert(employeeinfo);
		//Ա����ӳɹ��򽫶�Ӧ���û��ʺŽ��н�ɫ��
		FirstBase userrole=new FirstBase();
		userrole.setUser_id(employeeinfo.getUser_id());
		
		int role_id=positionInfoService.findRoleidById(employeeinfo.getPosition_id());
		userrole.setRole_id(role_id);
		firstBaseInfoService.insert(userrole);
		
		return "redirect:/employee/getAllEmployee?limit=10&pageIndex=0&searchname=null&position_id=0";
	}
	/**
	 * ɾ��Ա������
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete/{id}",method={RequestMethod.GET,RequestMethod.POST})
	public String delete(@PathVariable(value="id") int id){
		int result = employeeInfoService.deleteByPrimaryKey(id);
		System.out.println("ɾ��Ա���Ĳ������Ϊ��"+result+"���ݽ�����idΪ��"+id);
		return "redirect:/employee/getAllEmployee?limit=10&pageIndex=0&searchname=null&position_id=null";
	}
	/**
	 * ����ǰ�ȸ���id�ҵ�Ա����Ϣ�����Ե�ҳ����
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
	
	/*@RequestMapping(value="/addemployee",method=RequestMethod.PUT)
	public String update(Employee employeeinfo){
		employeeInfoService.updateByPrimaryKey(employeeinfo);
		return "redirect:/employee/getAllEmployee?limit=10&pageIndex=0&searchname=null&position_id=null";
	}*/
}
