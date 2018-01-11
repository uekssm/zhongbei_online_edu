package org.bb.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bb.ssm.model.Classroom;
import org.bb.ssm.service.ClassroomInfoService;
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
@RequestMapping(value="/classroom")
public class ClassroomInfoCotroller {
	
	@Autowired
	private ClassroomInfoService classroomInfoService;
	
	/**
	 * 用户列表页
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(Map<String, Object> map){
		//List<Classroom> ClassroomList = ClassroomInfoService.findAll();
		//map.put("ALLClassroom", ClassroomList);
		return "bui/acdemic/classroomList";
	}
	
	/**
	 * 得到所有用户信息
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/getAllClassroom",method=RequestMethod.POST)
	@ResponseBody
	public String getAllClassroom(Object pageinfo,Map<String, Object> map){
		System.out.println(pageinfo);
		List<Classroom> ClassroomList = classroomInfoService.findAll();
		
		HashMap<String,Object > tClassroom = new HashMap<String,Object >();
		
		tClassroom.put("rows", ClassroomList);
		tClassroom.put("results", ClassroomList.size());
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsondata = mapper.writeValueAsString(tClassroom);

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
	@RequestMapping(value="/addClassroom",method= RequestMethod.GET)
	public String addClassroom(Map<String, Object> map){
		//因为页面使用spring的form标签，其中属性modelAttribute需要存在bean 要不会报错
		map.put("command", new Classroom());
		return "addClassroom";
	}
	
	/**
	 * 添加用户操作
	 * @param Classroominfo
	 * @return
	 */
	@RequestMapping(value="/addClassroom",method=RequestMethod.POST)
	public String save(Classroom Classroominfo){
		int result = classroomInfoService.insert(Classroominfo);
		System.out.println("添加用户的操作结果为："+result);
		return "redirect:/classroom/getAllClassroom";
	}
	/**
	 * 删除用户操作
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable(value="id") int id){
		int result = classroomInfoService.deleteByPrimaryKey(id);
		System.out.println("删除用户的操作结果为："+result+"传递进来的id为："+id);
		return "redirect:/classroom/getAllClassroom";
	}
	/**
	 * 更新前先根据id找到用户信息，回显到页面上
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/detail/{id}",method=RequestMethod.GET)
	public String input(@PathVariable(value="id") Integer id,Map<String, Object> map){
		map.put("command", classroomInfoService.selectByPrimaryKey(id));
		return "addClassroom";
	}
	
	@ModelAttribute
	public void getClassroomInfo(@RequestParam(value="ClassroomId",required=false) Integer id
			,Map<String, Object> map){
		System.out.println("每个controller 方法都会先调用我哦");
		if(id != null){
			System.out.println("update 操作");
			map.put("ClassroomInfo", classroomInfoService.selectByPrimaryKey(id));
		}
		System.out.println("insert  操作");
	}
	
	@RequestMapping(value="/addClassroom",method=RequestMethod.PUT)
	public String update(Classroom Classroominfo){
		classroomInfoService.updateByPrimaryKey(Classroominfo);
		return "redirect:/classroom/getAllClassroom";
	}
}
