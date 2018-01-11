package org.bb.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bb.ssm.model.Direction;
import org.bb.ssm.service.DirectionInfoService;
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
@RequestMapping(value="/direction")
public class DirectionInfoCotroller {
	
	@Autowired
	private DirectionInfoService directionInfoService;
	
	/**
	 * 用户列表页
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(Map<String, Object> map){
		//List<direction> directionList = directionInfoService.findAll();
		//map.put("ALLdirection", directionList);
		return "bui/acdemic/directionList";
	}
	
	/**
	 * 得到所有用户信息
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/getAllDirection",method=RequestMethod.POST)
	@ResponseBody
	public String getAllDirection(Object pageinfo,Map<String, Object> map){
		System.out.println(pageinfo);
		List<Direction> directionList = directionInfoService.findAll();
		
		HashMap<String,Object > tdirection = new HashMap<String,Object >();
		
		tdirection.put("rows", directionList);
		tdirection.put("results", directionList.size());
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsondata = mapper.writeValueAsString(tdirection);

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
	@RequestMapping(value="/adddirection",method= RequestMethod.GET)
	public String adddirection(Map<String, Object> map){
		//因为页面使用spring的form标签，其中属性modelAttribute需要存在bean 要不会报错
		map.put("command", new Direction());
		return "adddirection";
	}
	
	/**
	 * 添加用户操作
	 * @param directioninfo
	 * @return
	 */
	@RequestMapping(value="/adddirection",method=RequestMethod.POST)
	public String save(Direction directioninfo){
		int result = directionInfoService.insert(directioninfo);
		System.out.println("添加用户的操作结果为："+result);
		return "redirect:/direction/getAllDirection";
	}
	/**
	 * 删除用户操作
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable(value="id") int id){
		int result = directionInfoService.deleteByPrimaryKey(id);
		System.out.println("删除用户的操作结果为："+result+"传递进来的id为："+id);
		return "redirect:/direction/getAllDirection";
	}
	/**
	 * 更新前先根据id找到用户信息，回显到页面上
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/detail/{id}",method=RequestMethod.GET)
	public String input(@PathVariable(value="id") Integer id,Map<String, Object> map){
		map.put("command", directionInfoService.selectByPrimaryKey(id));
		return "adddirection";
	}
	
	@ModelAttribute
	public void getdirectionInfo(@RequestParam(value="directionId",required=false) Integer id
			,Map<String, Object> map){
		System.out.println("每个controller 方法都会先调用我哦");
		if(id != null){
			System.out.println("update 操作");
			map.put("directionInfo", directionInfoService.selectByPrimaryKey(id));
		}
		System.out.println("insert  操作");
	}
	
	@RequestMapping(value="/adddirection",method=RequestMethod.PUT)
	public String update(Direction directioninfo){
		directionInfoService.updateByPrimaryKey(directioninfo);
		return "redirect:/direction/getAllDirection";
	}
}
