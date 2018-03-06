package org.bb.ssm.controller;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.bb.ssm.model.Students;
import org.bb.ssm.service.StudentsInfoService;
import org.bb.ssm.tool.ExcelImportUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping(value="/students")
public class StudentsInfoCotroller {
	
	@Autowired
	private StudentsInfoService studentsInfoService;
	
	/**
	 * 用户列表页
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
	 * 得到所有用户信息
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/getAllStudents",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String getAllStudents(@RequestParam(value="limit",required=false) Integer limit,@RequestParam(value="pageIndex",required=false) Integer pageIndex,@RequestParam(value="searchname",required=false) String searchname){
		pageIndex=pageIndex*limit;
		List<Students> StudentsList = studentsInfoService.findAll(limit,pageIndex,searchname);
		
		HashMap<String,Object > tStudents = new HashMap<String,Object >();
		
		tStudents.put("rows", StudentsList);
		tStudents.put("results", studentsInfoService.countStudent(searchname));
		
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
	 * 通过handler前往添加用户页面
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/addStudents",method= RequestMethod.GET)
	public String addStudents(Map<String, Object> map){
		//因为页面使用spring的form标签，其中属性modelAttribute需要存在bean 要不会报错
		map.put("command", new Students());
		return "addStudents";
	}
	
	/**
	 * 添加用户操作
	 * @param Studentsinfo
	 * @return
	 */
	@RequestMapping(value="/addStudents",method=RequestMethod.POST)
	public String save(Students Studentsinfo){
		int result = studentsInfoService.insert(Studentsinfo);
		System.out.println("添加用户的操作结果为："+result);
		return "redirect:/students/getAllStudents";
	}
	/**
	 * 删除用户操作
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable(value="id") int id){
		int result = studentsInfoService.deleteByPrimaryKey(id);
		System.out.println("删除用户的操作结果为："+result+"传递进来的id为："+id);
		return "redirect:/students/getAllStudents";
	}
	/**
	 * 更新前先根据id找到用户信息，回显到页面上
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
		System.out.println("每个controller 方法都会先调用我哦");
		if(id != null){
			System.out.println("update 操作");
			map.put("StudentsInfo", studentsInfoService.selectByPrimaryKey(id));
		}
		System.out.println("insert  操作");
	}
	
	@RequestMapping(value="/addStudents",method=RequestMethod.PUT)
	public String update(Students Studentsinfo){
		studentsInfoService.updateByPrimaryKey(Studentsinfo);
		return "redirect:/students/getAllStudents";
	}
	
	//批量导入用户
	@RequestMapping(value = "importStudents")  
    @ResponseBody  
    public String importStudents( @RequestParam(value = "excelFile") MultipartFile excelFile,HttpServletRequest request) throws Exception{  
        System.out.println("=========================");
		if (null == excelFile) {  
            String result = "模板文件为空,请选择文件";  
            return result;  
        }  
                  
//      String path = request.getSession().getServletContext().getRealPath("demo2");  
          
        String path = "E:\\demo";  
        //容错处理  
        File dir = new File(path);  
        if(!dir.exists()) {  
            dir.mkdirs();  
        }  
        String fileName = excelFile.getOriginalFilename();//report.xls  
        String fileName2 = excelFile.getName();//excelFile  
          
        InputStream fis = excelFile.getInputStream();  
         
        List<Map<String, String>>  data = ExcelImportUtil.parseExcel(fis); 
        System.out.println(data.get(0).get("学校"));
        //解析到的数据就可以做一些数据库的插入操作了……  
        int result = studentsInfoService.insertMore(data);
        
        
        return "success";  
    }  
	
}
