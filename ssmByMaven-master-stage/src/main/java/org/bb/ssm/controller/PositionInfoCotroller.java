package org.bb.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bb.ssm.model.Position;
import org.bb.ssm.service.PositionInfoService;
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
@RequestMapping(value="/position")
public class PositionInfoCotroller {
	
	@Autowired
	private PositionInfoService positionInfoService;
	
	/**
	 * 用户列表页
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(Map<String, Object> map){
		//List<position> positionList = positionInfoService.findAll();
		//map.put("ALLposition", positionList);
		return "bui/organization/positionList";
	}
	
	/**
	 * 得到所有用户信息
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/getAllPosition",method=RequestMethod.POST)
	@ResponseBody
	public String getAllPosition(Object pageinfo,Map<String, Object> map){
		System.out.println(pageinfo);
		List<Position> positionList = positionInfoService.findAll();
		
		HashMap<String,Object > tposition = new HashMap<String,Object >();
		
		tposition.put("rows", positionList);
		tposition.put("results", positionList.size());
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsondata = mapper.writeValueAsString(tposition);

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
	@RequestMapping(value="/addposition",method= RequestMethod.GET)
	public String addposition(Map<String, Object> map){
		//因为页面使用spring的form标签，其中属性modelAttribute需要存在bean 要不会报错
		map.put("command", new Position());
		return "addposition";
	}
	
	/**
	 * 添加用户操作
	 * @param positioninfo
	 * @return
	 */
	@RequestMapping(value="/addposition",method=RequestMethod.POST)
	public String save(Position positioninfo){
		int result = positionInfoService.insert(positioninfo);
		System.out.println("添加用户的操作结果为："+result);
		return "redirect:/position/getAllPosition";
	}
	/**
	 * 删除用户操作
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable(value="id") int id){
		int result = positionInfoService.deleteByPrimaryKey(id);
		System.out.println("删除用户的操作结果为："+result+"传递进来的id为："+id);
		return "redirect:/position/getAllPosition";
	}
	/**
	 * 更新前先根据id找到用户信息，回显到页面上
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/detail/{id}",method=RequestMethod.GET)
	public String input(@PathVariable(value="id") Integer id,Map<String, Object> map){
		map.put("command", positionInfoService.selectByPrimaryKey(id));
		return "addposition";
	}
	
	@ModelAttribute
	public void getpositionInfo(@RequestParam(value="positionId",required=false) Integer id
			,Map<String, Object> map){
		System.out.println("每个controller 方法都会先调用我哦");
		if(id != null){
			System.out.println("update 操作");
			map.put("positionInfo", positionInfoService.selectByPrimaryKey(id));
		}
		System.out.println("insert  操作");
	}
	
	@RequestMapping(value="/addposition",method=RequestMethod.PUT)
	public String update(Position positioninfo){
		positionInfoService.updateByPrimaryKey(positioninfo);
		return "redirect:/position/getAllPosition";
	}
}
