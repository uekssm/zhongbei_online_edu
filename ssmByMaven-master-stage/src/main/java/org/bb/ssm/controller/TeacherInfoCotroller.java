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
	 * �û��б�ҳ
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
	 * �õ������û���Ϣ
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
	 * ͨ��handlerǰ������û�ҳ��
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/addTeacher",method= RequestMethod.GET)
	public String addTeacher(Map<String, Object> map){
		//��Ϊҳ��ʹ��spring��form��ǩ����������modelAttribute��Ҫ����bean Ҫ���ᱨ��
		map.put("command", new Teacher());
		return "addTeacher";
	}
	
	/**
	 * ����û�����
	 * @param Teacherinfo
	 * @return
	 */
	@RequestMapping(value="/addTeacher",method=RequestMethod.POST)
	public String save(Teacher Teacherinfo){
		int result = teacherInfoService.insert(Teacherinfo);
		System.out.println("����û��Ĳ������Ϊ��"+result);
		return "redirect:/teacher/getAllTeacher";
	}
	/**
	 * ɾ���û�����
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable(value="id") int id){
		int result = teacherInfoService.deleteByPrimaryKey(id);
		System.out.println("ɾ���û��Ĳ������Ϊ��"+result+"���ݽ�����idΪ��"+id);
		return "redirect:/teacher/getAllTeacher";
	}
	/**
	 * ����ǰ�ȸ���id�ҵ��û���Ϣ�����Ե�ҳ����
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
		System.out.println("ÿ��controller ���������ȵ�����Ŷ");
		if(id != null){
			System.out.println("update ����");
			map.put("TeacherInfo", teacherInfoService.selectByPrimaryKey(id));
		}
		System.out.println("insert  ����");
	}
	
	@RequestMapping(value="/addTeacher",method=RequestMethod.PUT)
	public String update(Teacher Teacherinfo){
		teacherInfoService.updateByPrimaryKey(Teacherinfo);
		return "redirect:/teacher/getAllTeacher";
	}
}
