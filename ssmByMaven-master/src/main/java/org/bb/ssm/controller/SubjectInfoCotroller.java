package org.bb.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bb.ssm.model.Subject;
import org.bb.ssm.service.SubjectInfoService;
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
@RequestMapping(value="/subject")
public class SubjectInfoCotroller {
	
	@Autowired
	private SubjectInfoService subjectInfoService;
	
	/**
	 * 专业列表页
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(Map<String, Object> map){
		//List<subject> subjectList = subjectInfoService.findAll();
		//map.put("ALLsubject", subjectList);
		return "bui/acdemic/subjectList";
	}
	
	/**
	 * 得到所有专业信息
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/getAllSubject",method=RequestMethod.POST)
	@ResponseBody
	public String getAllSubject(Object pageinfo,Map<String, Object> map){
		System.out.println(pageinfo);
		List<Subject> subjectList = subjectInfoService.findAll();
		
		HashMap<String,Object > tsubject = new HashMap<String,Object >();
		
		tsubject.put("rows", subjectList);
		tsubject.put("results", subjectList.size());
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsondata = mapper.writeValueAsString(tsubject);

			//System.out.println(jsondata);
			
			return jsondata;
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 根据学院id获取专业信息
	 * @return
	 */
	@RequestMapping(value="/getSubjectByCollegeId",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String getSubjectByCollegeId(int collegeid){
		List<Subject> subjectList = subjectInfoService.getSubjectByCollegeId(collegeid);
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsondata = mapper.writeValueAsString(subjectList);

			return jsondata;
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 通过handler前往添加专业页面
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/addsubject",method= RequestMethod.GET)
	public String addsubject(Map<String, Object> map){
		//因为页面使用spring的form标签，其中属性modelAttribute需要存在bean 要不会报错
		map.put("command", new Subject());
		return "addsubject";
	}
	
	/**
	 * 添加专业操作
	 * @param subjectinfo
	 * @return
	 */
	@RequestMapping(value="/addsubject",method=RequestMethod.POST)
	public String save(Subject subjectinfo){
		int result = subjectInfoService.insert(subjectinfo);
		System.out.println("添加专业的操作结果为："+result);
		return "redirect:/subject/getAllSubject";
	}
	/**
	 * 删除专业操作
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable(value="id") int id){
		int result = subjectInfoService.deleteByPrimaryKey(id);
		System.out.println("删除专业的操作结果为："+result+"传递进来的id为："+id);
		return "redirect:/subject/getAllSubject";
	}
	/**
	 * 更新前先根据id找到专业信息，回显到页面上
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/detail/{id}",method=RequestMethod.GET)
	public String input(@PathVariable(value="id") Integer id,Map<String, Object> map){
		map.put("command", subjectInfoService.selectByPrimaryKey(id));
		return "addsubject";
	}
	
	@ModelAttribute
	public void getsubjectInfo(@RequestParam(value="subjectId",required=false) Integer id
			,Map<String, Object> map){
		System.out.println("每个controller 方法都会先调用我哦");
		if(id != null){
			System.out.println("update 操作");
			map.put("subjectInfo", subjectInfoService.selectByPrimaryKey(id));
		}
		System.out.println("insert  操作");
	}
	
	@RequestMapping(value="/addsubject",method=RequestMethod.PUT)
	public String update(Subject subjectinfo){
		subjectInfoService.updateByPrimaryKey(subjectinfo);
		return "redirect:/subject/getAllSubject";
	}
}
