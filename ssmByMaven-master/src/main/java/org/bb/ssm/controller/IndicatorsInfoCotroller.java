package org.bb.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bb.ssm.model.Indicators;
import org.bb.ssm.service.IndicatorsInfoService;
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
@RequestMapping(value="/indicators")
public class IndicatorsInfoCotroller {
	
	@Autowired
	private IndicatorsInfoService indicatorsInfoService;
	
	/**
	 * 用户列表页
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(Map<String, Object> map){
		//List<Indicators> IndicatorsList = IndicatorsInfoService.findAll();
		//map.put("ALLIndicators", IndicatorsList);
		return "bui/acdemic/indicatorsList";
	}
	
	/**
	 * 得到所有用户信息
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/getAllIndicators",method=RequestMethod.POST)
	@ResponseBody
	public String getAllIndicators(Object pageinfo,Map<String, Object> map){
		System.out.println(pageinfo);
		List<Indicators> IndicatorsList = indicatorsInfoService.findAll();
		
		HashMap<String,Object > tIndicators = new HashMap<String,Object >();
		
		tIndicators.put("rows", IndicatorsList);
		tIndicators.put("results", IndicatorsList.size());
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsondata = mapper.writeValueAsString(tIndicators);

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
	@RequestMapping(value="/addIndicators",method= RequestMethod.GET)
	public String addIndicators(Map<String, Object> map){
		//因为页面使用spring的form标签，其中属性modelAttribute需要存在bean 要不会报错
		map.put("command", new Indicators());
		return "addIndicators";
	}
	
	/**
	 * 添加用户操作
	 * @param Indicatorsinfo
	 * @return
	 */
	@RequestMapping(value="/addIndicators",method=RequestMethod.POST)
	public String save(Indicators Indicatorsinfo){
		int result = indicatorsInfoService.insert(Indicatorsinfo);
		System.out.println("添加用户的操作结果为："+result);
		return "redirect:/indicators/getAllIndicators";
	}
	/**
	 * 删除用户操作
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable(value="id") int id){
		int result = indicatorsInfoService.deleteByPrimaryKey(id);
		System.out.println("删除用户的操作结果为："+result+"传递进来的id为："+id);
		return "redirect:/indicators/getAllIndicators";
	}
	/**
	 * 更新前先根据id找到用户信息，回显到页面上
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/detail/{id}",method=RequestMethod.GET)
	public String input(@PathVariable(value="id") Integer id,Map<String, Object> map){
		map.put("command", indicatorsInfoService.selectByPrimaryKey(id));
		return "addIndicators";
	}
	
	@ModelAttribute
	public void getIndicatorsInfo(@RequestParam(value="IndicatorsId",required=false) Integer id
			,Map<String, Object> map){
		System.out.println("每个controller 方法都会先调用我哦");
		if(id != null){
			System.out.println("update 操作");
			map.put("IndicatorsInfo", indicatorsInfoService.selectByPrimaryKey(id));
		}
		System.out.println("insert  操作");
	}
	
	@RequestMapping(value="/addIndicators",method=RequestMethod.PUT)
	public String update(Indicators Indicatorsinfo){
		indicatorsInfoService.updateByPrimaryKey(Indicatorsinfo);
		return "redirect:/indicators/getAllIndicators";
	}
}
