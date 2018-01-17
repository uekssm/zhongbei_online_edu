package org.bb.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.bb.ssm.model.College;
import org.bb.ssm.model.Course;
import org.bb.ssm.model.SecBase;
import org.bb.ssm.model.Subject;
import org.bb.ssm.model.User;
import org.bb.ssm.service.CollegeInfoService;
import org.bb.ssm.service.CourseInfoService;
import org.bb.ssm.service.KnowledgeInfoService;
import org.bb.ssm.service.SecBaseInfoService;
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
@RequestMapping(value="/course")
public class CourseInfoCotroller {
	
	@Autowired
	private CourseInfoService courseInfoService;
	
	@Autowired
	private CollegeInfoService collegeInfoService;
	
	@Autowired
	private SubjectInfoService subjectInfoService;
	
	@Autowired
	private KnowledgeInfoService knowledgeInfoService;
	
	@Autowired
	private SecBaseInfoService secBaseInfoService;
	
	/**
	 * �γ��б�ҳ
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(Map<String, Object> map){
		//List<course> courseList = courseInfoService.findAll();
		//map.put("ALLcourse", courseList);
		//��ȡѧԺ��Ϣ
		List<College> collegenames =collegeInfoService.findAll();
		map.put("collegenames", collegenames);
		//��ȡרҵ��Ϣ----ѧ�Ʊ���num���ȴ��ڵ���6��
		
		//��ȡ�γ���Ϣ
		return "stage/courseList";
	}
	
	/**
	 * �첽��ȡרҵ��Ϣ
	 * @param collegeId=0
	 * @return
	 */
	@RequestMapping(value="/getSubject",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getSubject(int collegeId){
		System.out.println(collegeId);
		List<Subject> subjects = subjectInfoService.findAllMajor(collegeId);
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsondata = mapper.writeValueAsString(subjects);

			//System.out.println(jsondata);
			
			return jsondata;
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * ����id�ҵ���Ƶ��Ϣ
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/video/{id}",method=RequestMethod.GET)
	public String video(@PathVariable(value="id") Integer id,Map<String, Object> map,HttpSession httpSession){
		User userinfo=(User) httpSession.getAttribute("userinfo");
		//�ж��Ƿ��¼����¼����Ϣ����ҳ����
		if(userinfo!=null){
			map.put("userinfo", userinfo);
			//���ݵ�ǰ�û����Ҷ�Ӧ�Ĳ��ż�¼��������
			String overtime=secBaseInfoService.findtimeByUserid(userinfo.getId());
			if(overtime != null){
				map.put("overtime", overtime);
			}
		}
		map.put("videoinfo", knowledgeInfoService.selectByCourseId(134));
		return "stage/video";
	}
	
	@RequestMapping(value="/videorecord",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String videorecord(SecBase videorecord){
		//�����µļ�¼ֵǰ��ɾ��ԭ����
		secBaseInfoService.deleteByUserid(videorecord.getUser_id());
		secBaseInfoService.insert(videorecord);
		return null;
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
	 * @param college_id,subject_id,grade
	 * @return
	 */
	@RequestMapping(value="/getAllCourse",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String getAllCourse(int limit,int pageindex,int college_id,int subject_id,int grade){
		int offset=limit*pageindex;
		List<Course> courseList = courseInfoService.findAllCourse(limit,offset,college_id,subject_id,grade);
		
		HashMap<String,Object > tcourse = new HashMap<String,Object >();
		
		tcourse.put("rows", courseList);
		tcourse.put("results", courseInfoService.getCourseCount(college_id,subject_id,grade));
		
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
