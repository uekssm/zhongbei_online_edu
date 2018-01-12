package org.bb.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bb.ssm.model.College;
import org.bb.ssm.model.Course;
import org.bb.ssm.model.Subject;
import org.bb.ssm.service.CollegeInfoService;
import org.bb.ssm.service.CourseInfoService;
import org.bb.ssm.service.KnowledgeInfoService;
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
	
	/**
	 * 课程列表页
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(Map<String, Object> map){
		//List<course> courseList = courseInfoService.findAll();
		//map.put("ALLcourse", courseList);
		//读取学院信息
		List<College> collegenames =collegeInfoService.findAll();
		map.put("collegenames", collegenames);
		//读取专业信息----学科表中num长度大于等于6的
		
		//读取课程信息
		return "stage/courseList";
	}
	
	/**
	 * 异步获取专业信息
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
	 * 根据id找到视频信息
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
	 * 根据id找到职业路径信息
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
	 * 得到所有课程信息
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
	 * 通过handler前往添加课程页面
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/addcourse",method= RequestMethod.GET)
	public String addcourse(Map<String, Object> map){
		//因为页面使用spring的form标签，其中属性modelAttribute需要存在bean 要不会报错
		map.put("command", new Course());
		return "addcourse";
	}
	
	/**
	 * 添加课程操作
	 * @param courseinfo
	 * @return
	 */
	@RequestMapping(value="/addcourse",method=RequestMethod.POST)
	public String save(Course courseinfo){
		int result = courseInfoService.insert(courseinfo);
		System.out.println("添加课程的操作结果为："+result);
		return "redirect:/course/getAllCourse";
	}
	/**
	 * 删除课程操作
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable(value="id") int id){
		int result = courseInfoService.deleteByPrimaryKey(id);
		System.out.println("删除课程的操作结果为："+result+"传递进来的id为："+id);
		return "redirect:/course/getAllCourse";
	}
	/**
	 * 更新前先根据id找到课程信息，回显到页面上
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
		System.out.println("每个controller 方法都会先调用我哦");
		if(id != null){
			System.out.println("update 操作");
			map.put("courseInfo", courseInfoService.selectByPrimaryKey(id));
		}
		System.out.println("insert  操作");
	}
	
	@RequestMapping(value="/addcourse",method=RequestMethod.PUT)
	public String update(Course courseinfo){
		courseInfoService.updateByPrimaryKey(courseinfo);
		return "redirect:/course/getAllCourse";
	}
}
