package org.bb.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bb.ssm.model.College;
import org.bb.ssm.service.CollegeInfoService;
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
@RequestMapping(value="/college")
public class CollegeInfoCotroller {
	
	@Autowired
	private CollegeInfoService collegeInfoService;
	
	/**
	 * 用户列表页
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(Map<String, Object> map){
		//List<College> CollegeList = CollegeInfoService.findAll();
		//map.put("ALLCollege", CollegeList);
		return "bui/acdemic/collegeList";
	}
	
	/**
	 * 得到所有用户信息
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/getAllCollege",method=RequestMethod.POST)
	@ResponseBody
	public String getAllCollege(Object pageinfo,Map<String, Object> map){
		System.out.println(pageinfo);
		List<College> CollegeList = collegeInfoService.findAll();
		
		HashMap<String,Object > tCollege = new HashMap<String,Object >();
		
		tCollege.put("rows", CollegeList);
		tCollege.put("results", CollegeList.size());
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsondata = mapper.writeValueAsString(tCollege);

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
	@RequestMapping(value="/addCollege",method= RequestMethod.GET)
	public String addCollege(Map<String, Object> map){
		//因为页面使用spring的form标签，其中属性modelAttribute需要存在bean 要不会报错
		map.put("command", new College());
		return "addCollege";
	}
	
	/**
	 * 添加用户操作
	 * @param Collegeinfo
	 * @return
	 */
	@RequestMapping(value="/addCollege",method=RequestMethod.POST)
	public String save(College Collegeinfo){
		int result = collegeInfoService.insert(Collegeinfo);
		System.out.println("添加用户的操作结果为："+result);
		return "redirect:/college/getAllCollege";
	}
	/**
	 * 删除用户操作
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable(value="id") int id){
		int result = collegeInfoService.deleteByPrimaryKey(id);
		System.out.println("删除用户的操作结果为："+result+"传递进来的id为："+id);
		return "redirect:/college/getAllCollege";
	}
	/**
	 * 更新前先根据id找到用户信息，回显到页面上
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/detail/{id}",method=RequestMethod.GET)
	public String input(@PathVariable(value="id") Integer id,Map<String, Object> map){
		map.put("command", collegeInfoService.selectByPrimaryKey(id));
		return "addCollege";
	}
	
	@ModelAttribute
	public void getCollegeInfo(@RequestParam(value="CollegeId",required=false) Integer id
			,Map<String, Object> map){
		System.out.println("每个controller 方法都会先调用我哦");
		if(id != null){
			System.out.println("update 操作");
			map.put("CollegeInfo", collegeInfoService.selectByPrimaryKey(id));
		}
		System.out.println("insert  操作");
	}
	
	@RequestMapping(value="/addCollege",method=RequestMethod.PUT)
	public String update(College Collegeinfo){
		collegeInfoService.updateByPrimaryKey(Collegeinfo);
		return "redirect:/college/getAllCollege";
	}
}
