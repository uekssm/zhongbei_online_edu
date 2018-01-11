package org.bb.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bb.ssm.model.Students;
import org.bb.ssm.service.StudentsInfoService;
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
@RequestMapping(value="/students")
public class StudentsInfoCotroller {
	
	@Autowired
	private StudentsInfoService studentsInfoService;
	
	/**
	 * �û��б�ҳ
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(Map<String, Object> map){
		//List<Students> StudentsList = StudentsInfoService.findAll();
		//map.put("ALLStudents", StudentsList);
		return "bui/acdemic/studentsList";
	}
	
	/**
	 * �õ������û���Ϣ
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/getAllStudents",method=RequestMethod.POST)
	@ResponseBody
	public String getAllStudents(Object pageinfo,Map<String, Object> map){
		System.out.println(pageinfo);
		List<Students> StudentsList = studentsInfoService.findAll();
		
		HashMap<String,Object > tStudents = new HashMap<String,Object >();
		
		tStudents.put("rows", StudentsList);
		tStudents.put("results", StudentsList.size());
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsondata = mapper.writeValueAsString(tStudents);

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
	@RequestMapping(value="/addStudents",method= RequestMethod.GET)
	public String addStudents(Map<String, Object> map){
		//��Ϊҳ��ʹ��spring��form��ǩ����������modelAttribute��Ҫ����bean Ҫ���ᱨ��
		map.put("command", new Students());
		return "addStudents";
	}
	
	/**
	 * ����û�����
	 * @param Studentsinfo
	 * @return
	 */
	@RequestMapping(value="/addStudents",method=RequestMethod.POST)
	public String save(Students Studentsinfo){
		int result = studentsInfoService.insert(Studentsinfo);
		System.out.println("����û��Ĳ������Ϊ��"+result);
		return "redirect:/students/getAllStudents";
	}
	/**
	 * ɾ���û�����
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable(value="id") int id){
		int result = studentsInfoService.deleteByPrimaryKey(id);
		System.out.println("ɾ���û��Ĳ������Ϊ��"+result+"���ݽ�����idΪ��"+id);
		return "redirect:/students/getAllStudents";
	}
	/**
	 * ����ǰ�ȸ���id�ҵ��û���Ϣ�����Ե�ҳ����
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/detail/{id}",method=RequestMethod.GET)
	public String input(@PathVariable(value="id") Integer id,Map<String, Object> map){
		map.put("command", studentsInfoService.selectByPrimaryKey(id));
		return "addStudents";
	}
	
	@ModelAttribute
	public void getStudentsInfo(@RequestParam(value="StudentsId",required=false) Integer id
			,Map<String, Object> map){
		System.out.println("ÿ��controller ���������ȵ�����Ŷ");
		if(id != null){
			System.out.println("update ����");
			map.put("StudentsInfo", studentsInfoService.selectByPrimaryKey(id));
		}
		System.out.println("insert  ����");
	}
	
	@RequestMapping(value="/addStudents",method=RequestMethod.PUT)
	public String update(Students Studentsinfo){
		studentsInfoService.updateByPrimaryKey(Studentsinfo);
		return "redirect:/students/getAllStudents";
	}
}
