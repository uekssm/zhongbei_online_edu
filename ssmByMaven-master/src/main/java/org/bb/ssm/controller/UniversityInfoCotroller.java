package org.bb.ssm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.bb.ssm.model.University;
import org.bb.ssm.service.UniversityInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping(value="/university")
public class UniversityInfoCotroller {
	
	@Autowired
	private UniversityInfoService universityInfoService;
	
	/**
	 * 用户列表页
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(Map<String, Object> map){
		//List<university> universityList = universityInfoService.findAll();
		//map.put("ALLuniversity", universityList);
		return "bui/acdemic/universityList";
	}

	
	
	/**
	 * 得到所有用户信息
	 * @param map
	 * @return
	 */
	
	@RequestMapping(value="/getAllUniversity",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String getAllUniversity(@RequestParam(value="limit",required=false) Integer limit,@RequestParam(value="pageIndex",required=false) Integer pageIndex,@RequestParam(value="searchname",required=false) String searchname){
		pageIndex=pageIndex*limit;
		List<University> universityList = universityInfoService.findAll(limit,pageIndex,searchname);
		
		HashMap<String,Object > tuniversity = new HashMap<String,Object >();
		
		tuniversity.put("rows", universityList);
		tuniversity.put("results", universityInfoService.totalCount(searchname));
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsondata = mapper.writeValueAsString(tuniversity);

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
	/*@RequestMapping(value="/adduniversity",method= RequestMethod.GET)
	public String adduniversity(Map<String, Object> map){
		//因为页面使用spring的form标签，其中属性modelAttribute需要存在bean 要不会报错
		map.put("command", new University());
		return "adduniversity";
	}*/
	
	/**
	 * 添加学校操作
	 * @param universityinfo
	 * @return
	 */
	@RequestMapping(value="/adduniversity",method=RequestMethod.POST)
	public String save(University universityinfo){
		//int result = universityInfoService.insert(universityinfo);
		universityInfoService.insert(universityinfo);
		//System.out.println("添加学校的操作结果为："+result);
		return "redirect:/university/getAllUniversity?limit=10&pageIndex=0&searchname=''";
	}
	/**
	 * 删除用户操作
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String delete(@RequestParam(value="ids[]") String[] ids){
		
		universityInfoService.deleteByPrimaryKey(ids);
		return "redirect:/university/getAllUniversity?limit=10&pageIndex=0&searchname=''";
	}
	/**
	 * 更新前先根据id找到用户信息，回显到页面上
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/detail/{id}",method=RequestMethod.GET)
	public String input(@PathVariable(value="id") Integer id,Map<String, Object> map){
		map.put("command", universityInfoService.selectByPrimaryKey(id));
		return "adduniversity";
	}
	
	@ModelAttribute
	public void getuniversityInfo(@RequestParam(value="universityId",required=false) Integer id
			,Map<String, Object> map){
		System.out.println("每个controller 方法都会先调用我哦");
		if(id != null){
			System.out.println("update 操作");
			map.put("universityInfo", universityInfoService.selectByPrimaryKey(id));
		}
		System.out.println("insert  操作");
	}
	
	@RequestMapping(value="/updateuniversity",method=RequestMethod.POST)
	public String update(University universityinfo){
		universityInfoService.updateByPrimaryKey(universityinfo);
		return "redirect:/university/getAllUniversity";
	}
}
