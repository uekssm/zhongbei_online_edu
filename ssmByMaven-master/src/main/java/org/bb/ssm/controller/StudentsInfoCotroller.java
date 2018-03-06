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
	
	//���������û�
	@RequestMapping(value = "importStudents")  
    @ResponseBody  
    public String importStudents( @RequestParam(value = "excelFile") MultipartFile excelFile,HttpServletRequest request) throws Exception{  
        System.out.println("=========================");
		if (null == excelFile) {  
            String result = "ģ���ļ�Ϊ��,��ѡ���ļ�";  
            return result;  
        }  
                  
//      String path = request.getSession().getServletContext().getRealPath("demo2");  
          
        String path = "E:\\demo";  
        //�ݴ���  
        File dir = new File(path);  
        if(!dir.exists()) {  
            dir.mkdirs();  
        }  
        String fileName = excelFile.getOriginalFilename();//report.xls  
        String fileName2 = excelFile.getName();//excelFile  
          
        InputStream fis = excelFile.getInputStream();  
         
        List<Map<String, String>>  data = ExcelImportUtil.parseExcel(fis); 
        System.out.println(data.get(0).get("ѧУ"));
        //�����������ݾͿ�����һЩ���ݿ�Ĳ�������ˡ���  
        int result = studentsInfoService.insertMore(data);
        
        
        return "success";  
    }  
	
}
