package org.bb.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bb.ssm.model.Department;
import org.bb.ssm.service.DepartmentInfoService;
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
@RequestMapping(value="/department")
public class DepartmentInfoCotroller {
	
	@Autowired
	private DepartmentInfoService departmentInfoService;
	
	/**
	 * 用户列表页
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(Map<String, Object> map){
		//List<department> departmentList = departmentInfoService.findAll();
		//map.put("ALLdepartment", departmentList);
		return "bui/organization/departmentList";
	}
	
	/**
	 * 得到所有用户信息
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/getAllDepartment",method=RequestMethod.POST)
	@ResponseBody
	public String getAllDepartment(Object pageinfo,Map<String, Object> map){
		System.out.println(pageinfo);
		List<Department> departmentList = departmentInfoService.findAll();
		
		HashMap<String,Object > tdepartment = new HashMap<String,Object >();
		
		tdepartment.put("rows", departmentList);
		tdepartment.put("results", departmentList.size());
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsondata = mapper.writeValueAsString(tdepartment);

			//System.out.println(jsondata);
			
			return jsondata;
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 通过handler前往添加用户页面
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/adddepartment",method= RequestMethod.GET)
	public String adddepartment(Map<String, Object> map){
		//因为页面使用spring的form标签，其中属性modelAttribute需要存在bean 要不会报错
		map.put("command", new Department());
		return "adddepartment";
	}
	
	/**
	 * 添加用户操作
	 * @param departmentinfo
	 * @return
	 */
	@RequestMapping(value="/adddepartment",method=RequestMethod.POST)
	public String save(Department departmentinfo){
		int result = departmentInfoService.insert(departmentinfo);
		System.out.println("添加用户的操作结果为："+result);
		return "redirect:/department/getAllDepartment";
	}
	/**
	 * 删除用户操作
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable(value="id") int id){
		int result = departmentInfoService.deleteByPrimaryKey(id);
		System.out.println("删除用户的操作结果为："+result+"传递进来的id为："+id);
		return "redirect:/department/getAllDepartment";
	}
	/**
	 * 更新前先根据id找到用户信息，回显到页面上
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/detail/{id}",method=RequestMethod.GET)
	public String input(@PathVariable(value="id") Integer id,Map<String, Object> map){
		map.put("command", departmentInfoService.selectByPrimaryKey(id));
		return "adddepartment";
	}
	
	@ModelAttribute
	public void getdepartmentInfo(@RequestParam(value="departmentId",required=false) Integer id
			,Map<String, Object> map){
		System.out.println("每个controller 方法都会先调用我哦");
		if(id != null){
			System.out.println("update 操作");
			map.put("departmentInfo", departmentInfoService.selectByPrimaryKey(id));
		}
		System.out.println("insert  操作");
	}
	
	@RequestMapping(value="/adddepartment",method=RequestMethod.PUT)
	public String update(Department departmentinfo){
		departmentInfoService.updateByPrimaryKey(departmentinfo);
		return "redirect:/department/getAllDepartment";
	}
}
