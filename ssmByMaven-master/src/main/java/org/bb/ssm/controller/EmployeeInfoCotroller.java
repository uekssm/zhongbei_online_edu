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
	 * 员工列表页
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
	 * 得到所有员工信息
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
	 * 通过handler前往添加员工页面
	 * @param map
	 * @return
	 */
	/*@RequestMapping(value="/addemployee",method= RequestMethod.GET)
	public String addemployee(Map<String, Object> map){
		//因为页面使用spring的form标签，其中属性modelAttribute需要存在bean 要不会报错
		map.put("command", new Employee());
		return "addemployee";
	}*/
	
	/**
	 * 添加员工操作
	 * @param employeeinfo
	 * @return
	 */
	@RequestMapping(value="/addemployee")
	public String save(Employee employeeinfo){
		//插入员工之前先添加用户
		User userinfo=new User();
		userinfo.setUsername(employeeinfo.getName());
		
		try {
			String pwd="111111";
	        // 生成一个MD5加密计算摘要
	        MessageDigest md;
			md = MessageDigest.getInstance("MD5");
			 // 计算md5函数
	        md.update(pwd.getBytes());
	        // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
	        // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
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
		//员工添加成功则将对应的用户帐号进行角色绑定
		FirstBase userrole=new FirstBase();
		userrole.setUser_id(employeeinfo.getUser_id());
		
		int role_id=positionInfoService.findRoleidById(employeeinfo.getPosition_id());
		userrole.setRole_id(role_id);
		firstBaseInfoService.insert(userrole);
		
		return "redirect:/employee/getAllEmployee?limit=10&pageIndex=0&searchname=null&position_id=0";
	}
	/**
	 * 删除员工操作
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete/{id}",method={RequestMethod.GET,RequestMethod.POST})
	public String delete(@PathVariable(value="id") int id){
		int result = employeeInfoService.deleteByPrimaryKey(id);
		System.out.println("删除员工的操作结果为："+result+"传递进来的id为："+id);
		return "redirect:/employee/getAllEmployee?limit=10&pageIndex=0&searchname=null&position_id=null";
	}
	/**
	 * 更新前先根据id找到员工信息，回显到页面上
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
		System.out.println("每个controller 方法都会先调用我哦");
		if(id != null){
			System.out.println("update 操作");
			map.put("employeeInfo", employeeInfoService.selectByPrimaryKey(id));
		}
		System.out.println("insert  操作");
	}
	
	/*@RequestMapping(value="/addemployee",method=RequestMethod.PUT)
	public String update(Employee employeeinfo){
		employeeInfoService.updateByPrimaryKey(employeeinfo);
		return "redirect:/employee/getAllEmployee?limit=10&pageIndex=0&searchname=null&position_id=null";
	}*/
}
