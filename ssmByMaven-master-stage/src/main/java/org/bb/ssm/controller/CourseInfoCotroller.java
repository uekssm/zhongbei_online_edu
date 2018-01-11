package org.bb.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bb.ssm.model.Course;
import org.bb.ssm.service.CourseInfoService;
import org.bb.ssm.service.KnowledgeInfoService;
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
@RequestMapping(value="/course")
public class CourseInfoCotroller {
	
	@Autowired
	private CourseInfoService courseInfoService;
	
	@Autowired
	private KnowledgeInfoService knowledgeInfoService;
	
	/**
	 * �γ��б�ҳ
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(Map<String, Object> map){
		//List<course> courseList = courseInfoService.findAll();
		//map.put("ALLcourse", courseList);
		return "stage/courseList";
	}
	
	/**
	 * ����id�ҵ���Ƶ��Ϣ
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/video/{id}",method=RequestMethod.GET)
	public String video(@PathVariable(value="id") Integer id,Map<String, Object> map){
		map.put("videoinfo", knowledgeInfoService.selectByCourseId(id));
		return "stage/video";
	}
	
	/**
	 * ����id�ҵ�ְҵ·����Ϣ
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/coursePath/{id}",method=RequestMethod.GET)
	public String coursePath(@PathVariable(value="id") Integer id,Map<String, Object> map){
		map.put("command", courseInfoService.selectByPrimaryKey(id));
		return "stage/coursePath";
	}
	
	/**
	 * �õ����пγ���Ϣ
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/getAllCourse",method=RequestMethod.POST)
	@ResponseBody
	public String getAllCourse(Object pageinfo,Map<String, Object> map){
		System.out.println(pageinfo);
		List<Course> courseList = courseInfoService.findAll();
		
		HashMap<String,Object > tcourse = new HashMap<String,Object >();
		
		tcourse.put("rows", courseList);
		tcourse.put("results", courseList.size());
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsondata = mapper.writeValueAsString(tcourse);

			//System.out.println(jsondata);
			
			return jsondata;
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * ͨ��handlerǰ����ӿγ�ҳ��
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/addcourse",method= RequestMethod.GET)
	public String addcourse(Map<String, Object> map){
		//��Ϊҳ��ʹ��spring��form��ǩ����������modelAttribute��Ҫ����bean Ҫ���ᱨ��
		map.put("command", new Course());
		return "addcourse";
	}
	
	/**
	 * ��ӿγ̲���
	 * @param courseinfo
	 * @return
	 */
	@RequestMapping(value="/addcourse",method=RequestMethod.POST)
	public String save(Course courseinfo){
		int result = courseInfoService.insert(courseinfo);
		System.out.println("��ӿγ̵Ĳ������Ϊ��"+result);
		return "redirect:/course/getAllCourse";
	}
	/**
	 * ɾ���γ̲���
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable(value="id") int id){
		int result = courseInfoService.deleteByPrimaryKey(id);
		System.out.println("ɾ���γ̵Ĳ������Ϊ��"+result+"���ݽ�����idΪ��"+id);
		return "redirect:/course/getAllCourse";
	}
	/**
	 * ����ǰ�ȸ���id�ҵ��γ���Ϣ�����Ե�ҳ����
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/detail/{id}",method=RequestMethod.GET)
	public String input(@PathVariable(value="id") Integer id,Map<String, Object> map){
		map.put("command", courseInfoService.selectByPrimaryKey(id));
		return "addcourse";
	}
	
	@ModelAttribute
	public void getcourseInfo(@RequestParam(value="courseId",required=false) Integer id
			,Map<String, Object> map){
		System.out.println("ÿ��controller ���������ȵ�����Ŷ");
		if(id != null){
			System.out.println("update ����");
			map.put("courseInfo", courseInfoService.selectByPrimaryKey(id));
		}
		System.out.println("insert  ����");
	}
	
	@RequestMapping(value="/addcourse",method=RequestMethod.PUT)
	public String update(Course courseinfo){
		courseInfoService.updateByPrimaryKey(courseinfo);
		return "redirect:/course/getAllCourse";
	}
}
