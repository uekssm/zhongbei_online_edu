package org.bb.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bb.ssm.model.Teacher;
import org.bb.ssm.service.TeacherInfoService;
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
@RequestMapping(value="/teacher")
public class TeacherInfoCotroller {
	
	@Autowired
	private TeacherInfoService teacherInfoService;
	
	/**
	 * 用户列表页
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(Map<String, Object> map){
		//List<Teacher> TeacherList = TeacherInfoService.findAll();
		//map.put("ALLTeacher", TeacherList);
		return "bui/acdemic/teacherList";
	}
	
	/**
	 * 得到所有用户信息
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/getAllTeacher",method=RequestMethod.POST)
	@ResponseBody
	public String getAllTeacher(Object pageinfo,Map<String, Object> map){
		System.out.println(pageinfo);
		List<Teacher> TeacherList = teacherInfoService.findAll();
		
		HashMap<String,Object > tTeacher = new HashMap<String,Object >();
		
		tTeacher.put("rows", TeacherList);
		tTeacher.put("results", TeacherList.size());
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsondata = mapper.writeValueAsString(tTeacher);

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
	@RequestMapping(value="/addTeacher",method= RequestMethod.GET)
	public String addTeacher(Map<String, Object> map){
		//因为页面使用spring的form标签，其中属性modelAttribute需要存在bean 要不会报错
		map.put("command", new Teacher());
		return "addTeacher";
	}
	
	/**
	 * 添加用户操作
	 * @param Teacherinfo
	 * @return
	 */
	@RequestMapping(value="/addTeacher",method=RequestMethod.POST)
	public String save(Teacher Teacherinfo){
		int result = teacherInfoService.insert(Teacherinfo);
		System.out.println("添加用户的操作结果为："+result);
		return "redirect:/teacher/getAllTeacher";
	}
	/**
	 * 删除用户操作
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable(value="id") int id){
		int result = teacherInfoService.deleteByPrimaryKey(id);
		System.out.println("删除用户的操作结果为："+result+"传递进来的id为："+id);
		return "redirect:/teacher/getAllTeacher";
	}
	/**
	 * 更新前先根据id找到用户信息，回显到页面上
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/detail/{id}",method=RequestMethod.GET)
	public String input(@PathVariable(value="id") Integer id,Map<String, Object> map){
		map.put("command", teacherInfoService.selectByPrimaryKey(id));
		return "addTeacher";
	}
	
	@ModelAttribute
	public void getTeacherInfo(@RequestParam(value="TeacherId",required=false) Integer id
			,Map<String, Object> map){
		System.out.println("每个controller 方法都会先调用我哦");
		if(id != null){
			System.out.println("update 操作");
			map.put("TeacherInfo", teacherInfoService.selectByPrimaryKey(id));
		}
		System.out.println("insert  操作");
	}
	
	@RequestMapping(value="/addTeacher",method=RequestMethod.PUT)
	public String update(Teacher Teacherinfo){
		teacherInfoService.updateByPrimaryKey(Teacherinfo);
		return "redirect:/teacher/getAllTeacher";
	}
}
