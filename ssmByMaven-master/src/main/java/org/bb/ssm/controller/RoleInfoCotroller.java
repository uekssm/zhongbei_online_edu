package org.bb.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bb.ssm.model.Role;
import org.bb.ssm.service.RoleInfoService;
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
@RequestMapping(value="/role")
public class RoleInfoCotroller {
	
	@Autowired
	private RoleInfoService roleInfoService;
	
	/**
	 * 角色列表页
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(Map<String, Object> map){
		//List<User> userList = userInfoService.findAll();
		//map.put("ALLUSER", userList);
		return "bui/system/roleList";
	}
	
	/**
	 * 得到所有用户信息
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/getAllRole",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String getAllRole(@RequestParam(value="limit",required=false) Integer limit,@RequestParam(value="pageIndex",required=false) Integer pageIndex,@RequestParam(value="searchname",required=false) String searchname){
		pageIndex=pageIndex*limit;
		List<Role> roleList = roleInfoService.findAll(limit,pageIndex,searchname);
		HashMap<String,Object > tUser = new HashMap<String,Object >();
		
		tUser.put("rows", roleList);
		tUser.put("results", roleInfoService.totalCount(searchname));
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsondata = mapper.writeValueAsString(tUser);

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
	@RequestMapping(value="/addRole",method= RequestMethod.GET)
	public String addRole(Map<String, Object> map){
		//因为页面使用spring的form标签，其中属性modelAttribute需要存在bean 要不会报错
		map.put("command", new Role());
		return "addRole";
	}
	
	/**
	 * 添加用户操作
	 * @param roleinfo
	 * @return
	 */
	@RequestMapping(value="/addRole",method=RequestMethod.POST)
	public String save(Role roleinfo){
		int result = roleInfoService.insert(roleinfo);
		System.out.println("添加用户的操作结果为："+result);
		return "redirect:/role/getAllRole";
	}
	/**
	 * 删除用户操作
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable(value="id") int id){
		int result = roleInfoService.deleteByPrimaryKey(id);
		System.out.println("删除用户的操作结果为："+result+"传递进来的id为："+id);
		return "redirect:/role/getAllRole";
	}
	/**
	 * 更新前先根据id找到用户信息，回显到页面上
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/detail/{id}",method=RequestMethod.GET)
	public String input(@PathVariable(value="id") Integer id,Map<String, Object> map){
		map.put("command", roleInfoService.selectByPrimaryKey(id));
		return "addRole";
	}
	
	@ModelAttribute
	public void getRoleInfo(@RequestParam(value="roleId",required=false) Integer id
			,Map<String, Object> map){
		System.out.println("每个controller 方法都会先调用我哦");
		if(id != null){
			System.out.println("update 操作");
			map.put("roleInfo", roleInfoService.selectByPrimaryKey(id));
		}
		System.out.println("insert  操作");
	}
	
	@RequestMapping(value="/addRole",method=RequestMethod.PUT)
	public String update(Role roleinfo){
		roleInfoService.updateByPrimaryKey(roleinfo);
		return "redirect:/role/getAllRole";
	}
}
