package org.bb.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bb.ssm.model.Class;
import org.bb.ssm.service.ClassInfoService;
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
@RequestMapping(value="/class")
public class ClassInfoCotroller {
	
	@Autowired
	private ClassInfoService classInfoService;
	
	/**
	 * 用户列表页
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(Map<String, Object> map){
		//List<Class> ClassList = ClassInfoService.findAll();
		//map.put("ALLClass", ClassList);
		return "bui/acdemic/classList";
	}
	
	/**
	 * 得到所有用户信息
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/getAllClass",method=RequestMethod.POST)
	@ResponseBody
	public String getAllClass(Object pageinfo,Map<String, Object> map){
		System.out.println(pageinfo);
		List<Class> ClassList = classInfoService.findAll();
		
		HashMap<String,Object > tClass = new HashMap<String,Object >();
		
		tClass.put("rows", ClassList);
		tClass.put("results", ClassList.size());
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsondata = mapper.writeValueAsString(tClass);

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
	@RequestMapping(value="/addClass",method= RequestMethod.GET)
	public String addClass(Map<String, Object> map){
		//因为页面使用spring的form标签，其中属性modelAttribute需要存在bean 要不会报错
		map.put("command", new Class());
		return "addClass";
	}
	
	/**
	 * 添加用户操作
	 * @param Classinfo
	 * @return
	 */
	@RequestMapping(value="/addClass",method=RequestMethod.POST)
	public String save(Class Classinfo){
		int result = classInfoService.insert(Classinfo);
		System.out.println("添加用户的操作结果为："+result);
		return "redirect:/class/getAllClass";
	}
	/**
	 * 删除用户操作
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable(value="id") int id){
		int result = classInfoService.deleteByPrimaryKey(id);
		System.out.println("删除用户的操作结果为："+result+"传递进来的id为："+id);
		return "redirect:/class/getAllClass";
	}
	/**
	 * 更新前先根据id找到用户信息，回显到页面上
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/detail/{id}",method=RequestMethod.GET)
	public String input(@PathVariable(value="id") Integer id,Map<String, Object> map){
		map.put("command", classInfoService.selectByPrimaryKey(id));
		return "addClass";
	}
	
	@ModelAttribute
	public void getClassInfo(@RequestParam(value="ClassId",required=false) Integer id
			,Map<String, Object> map){
		System.out.println("每个controller 方法都会先调用我哦");
		if(id != null){
			System.out.println("update 操作");
			map.put("ClassInfo", classInfoService.selectByPrimaryKey(id));
		}
		System.out.println("insert  操作");
	}
	
	@RequestMapping(value="/addClass",method=RequestMethod.PUT)
	public String update(Class Classinfo){
		classInfoService.updateByPrimaryKey(Classinfo);
		return "redirect:/class/getAllClass";
	}
}
