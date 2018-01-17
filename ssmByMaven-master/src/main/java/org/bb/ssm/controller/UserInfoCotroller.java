package org.bb.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bb.ssm.model.FirstBase;
import org.bb.ssm.model.Role;
import org.bb.ssm.model.User;
import org.bb.ssm.service.FirstBaseInfoService;
import org.bb.ssm.service.RoleInfoService;
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
@RequestMapping(value="/user")
public class UserInfoCotroller {
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private RoleInfoService roleInfoService;
	
	@Autowired
	private FirstBaseInfoService firstBaseInfoService;
	
	/**
	 * 用户列表页
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(Map<String, Object> map){
		List<Role> roleList = roleInfoService.findAll(null, null, null);
		map.put("allrole", roleList);
		System.out.println(roleList);
		return "bui/system/userList";
	}
	
	/**
	 * 得到所有用户信息
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/getAllUser",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String getAllUser(@RequestParam(value="limit",required=false) Integer limit,@RequestParam(value="pageIndex",required=false) Integer pageIndex,@RequestParam(value="searchname",required=false) String searchname,@RequestParam(value="status",required=false) Integer status){
		pageIndex=pageIndex*limit;
		List<User> userList = userInfoService.findAll(limit,pageIndex,searchname,status);
		
		HashMap<String,Object > tUser = new HashMap<String,Object >();
		
		tUser.put("rows", userList);
		tUser.put("results", userInfoService.totalCount(searchname,status));
		
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
	@RequestMapping(value="/addUser",method= RequestMethod.GET)
	public String addUser(Map<String, Object> map){
		//因为页面使用spring的form标签，其中属性modelAttribute需要存在bean 要不会报错
		map.put("command", new User());
		return "addUser";
	}
	
	@RequestMapping(value="/bind_Roles",method= {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String bindRoles(@RequestParam(value="user_id",required=false) Integer user_id,@RequestParam(value="role_ids",required=false) String role_ids){
		String[] roleids=role_ids.split(",");
		//遍历所有角色，依次绑定,绑定之前删除该用户原来的绑定信息
		firstBaseInfoService.deleteByUserid(user_id);
		for (int i = 0; i < roleids.length; i++) {
			FirstBase userrole=new FirstBase();
			userrole.setUser_id(user_id);
			userrole.setRole_id(Integer.parseInt(roleids[i]));
			firstBaseInfoService.insert(userrole);
		}
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsondata = mapper.writeValueAsString(roleids);

			return jsondata;
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 添加用户操作
	 * @param userinfo
	 * @return
	 */
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public String save(User userinfo){
		int result = userInfoService.insert(userinfo);
		System.out.println("添加用户的操作结果为："+result);
		return "redirect:/user/getAllUser";
	}
	/**
	 * 删除用户操作
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable(value="id") int id){
		int result = userInfoService.deleteByPrimaryKey(id);
		System.out.println("删除用户的操作结果为："+result+"传递进来的id为："+id);
		return "redirect:/user/getAllUser";
	}
	/**
	 * 更新前先根据id找到用户信息，回显到页面上
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/detail/{id}",method=RequestMethod.GET)
	public String input(@PathVariable(value="id") Integer id,Map<String, Object> map){
		map.put("command", userInfoService.selectByPrimaryKey(id));
		return "addUser";
	}
	
	@ModelAttribute
	public void getUserInfo(@RequestParam(value="userId",required=false) Integer id
			,Map<String, Object> map){
		System.out.println("每个controller 方法都会先调用我哦");
		if(id != null){
			System.out.println("update 操作");
			map.put("userInfo", userInfoService.selectByPrimaryKey(id));
		}
		System.out.println("insert  操作");
	}
	
	@RequestMapping(value="/addUser",method=RequestMethod.PUT)
	public String update(User userinfo){
		userInfoService.updateByPrimaryKey(userinfo);
		return "redirect:/user/getAllUser";
	}
}
