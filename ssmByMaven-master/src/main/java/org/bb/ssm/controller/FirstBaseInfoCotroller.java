package org.bb.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bb.ssm.model.Role;
import org.bb.ssm.model.FirstBase;
import org.bb.ssm.service.RoleInfoService;
import org.bb.ssm.service.FirstBaseInfoService;
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
@RequestMapping(value="/firstBase")
public class FirstBaseInfoCotroller {
	
	@Autowired
	private FirstBaseInfoService firstBaseInfoService;
	
	@Autowired
	private RoleInfoService roleInfoService;
	
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
		return "bui/system/firstBaseList";
	}
	
	/**
	 * 得到所有用户信息
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/getAllFirstBase",method=RequestMethod.POST)
	@ResponseBody
	public String getAllFirstBase(Object pageinfo,Map<String, Object> map){
		System.out.println(pageinfo);
		List<FirstBase> firstBaseList = firstBaseInfoService.findAll();
		
		HashMap<String,Object > tFirstBase = new HashMap<String,Object >();
		
		tFirstBase.put("rows", firstBaseList);
		tFirstBase.put("results", firstBaseList.size());
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsondata = mapper.writeValueAsString(tFirstBase);

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
	@RequestMapping(value="/addFirstBase",method= RequestMethod.GET)
	public String addFirstBase(Map<String, Object> map){
		//因为页面使用spring的form标签，其中属性modelAttribute需要存在bean 要不会报错
		map.put("command", new FirstBase());
		return "addFirstBase";
	}
	
	/**
	 * 添加用户操作
	 * @param firstBaseinfo
	 * @return
	 */
	@RequestMapping(value="/addFirstBase",method=RequestMethod.POST)
	public String save(FirstBase firstBaseinfo){
		int result = firstBaseInfoService.insert(firstBaseinfo);
		System.out.println("添加用户的操作结果为："+result);
		return "redirect:/firstBase/getAllFirstBase";
	}
	/**
	 * 删除用户操作
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable(value="id") int id){
		int result = firstBaseInfoService.deleteByPrimaryKey(id);
		System.out.println("删除用户的操作结果为："+result+"传递进来的id为："+id);
		return "redirect:/firstBase/getAllFirstBase";
	}
	/**
	 * 更新前先根据id找到用户信息，回显到页面上
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/detail/{id}",method=RequestMethod.GET)
	public String input(@PathVariable(value="id") Integer id,Map<String, Object> map){
		map.put("command", firstBaseInfoService.selectByPrimaryKey(id));
		return "addFirstBase";
	}
	
	@ModelAttribute
	public void getFirstBaseInfo(@RequestParam(value="firstBaseId",required=false) Integer id
			,Map<String, Object> map){
		System.out.println("每个controller 方法都会先调用我哦");
		if(id != null){
			System.out.println("update 操作");
			map.put("firstBaseInfo", firstBaseInfoService.selectByPrimaryKey(id));
		}
		System.out.println("insert  操作");
	}
	
	@RequestMapping(value="/addFirstBase",method=RequestMethod.PUT)
	public String update(FirstBase firstBaseinfo){
		firstBaseInfoService.updateByPrimaryKey(firstBaseinfo);
		return "redirect:/firstBase/getAllFirstBase";
	}
}
