package org.bb.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bb.ssm.model.Class;
import org.bb.ssm.service.ClassInfoService;
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
@RequestMapping(value="/class")
public class ClassInfoCotroller {
	
	@Autowired
	private ClassInfoService classInfoService;
	
	/**
	 * �û��б�ҳ
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(Map<String, Object> map){
		//List<Class> ClassList = ClassInfoService.findAll();
		//map.put("ALLClass", ClassList);
		return "bui/acdemic/classList";
	}
	
	/**
	 * �õ������û���Ϣ
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/getAllClass",method=RequestMethod.POST)
	@ResponseBody
	public String getAllClass(Object pageinfo,Map<String, Object> map){
		System.out.println(pageinfo);
		List<Class> ClassList = classInfoService.findAll();
		
		HashMap<String,Object > tClass = new HashMap<String,Object >();
		
		tClass.put("rows", ClassList);
		tClass.put("results", ClassList.size());
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsondata = mapper.writeValueAsString(tClass);

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
	@RequestMapping(value="/addClass",method= RequestMethod.GET)
	public String addClass(Map<String, Object> map){
		//��Ϊҳ��ʹ��spring��form��ǩ����������modelAttribute��Ҫ����bean Ҫ���ᱨ��
		map.put("command", new Class());
		return "addClass";
	}
	
	/**
	 * ����û�����
	 * @param Classinfo
	 * @return
	 */
	@RequestMapping(value="/addClass",method=RequestMethod.POST)
	public String save(Class Classinfo){
		int result = classInfoService.insert(Classinfo);
		System.out.println("����û��Ĳ������Ϊ��"+result);
		return "redirect:/class/getAllClass";
	}
	/**
	 * ɾ���û�����
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable(value="id") int id){
		int result = classInfoService.deleteByPrimaryKey(id);
		System.out.println("ɾ���û��Ĳ������Ϊ��"+result+"���ݽ�����idΪ��"+id);
		return "redirect:/class/getAllClass";
	}
	/**
	 * ����ǰ�ȸ���id�ҵ��û���Ϣ�����Ե�ҳ����
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/detail/{id}",method=RequestMethod.GET)
	public String input(@PathVariable(value="id") Integer id,Map<String, Object> map){
		map.put("command", classInfoService.selectByPrimaryKey(id));
		return "addClass";
	}
	
	@ModelAttribute
	public void getClassInfo(@RequestParam(value="ClassId",required=false) Integer id
			,Map<String, Object> map){
		System.out.println("ÿ��controller ���������ȵ�����Ŷ");
		if(id != null){
			System.out.println("update ����");
			map.put("ClassInfo", classInfoService.selectByPrimaryKey(id));
		}
		System.out.println("insert  ����");
	}
	
	@RequestMapping(value="/addClass",method=RequestMethod.PUT)
	public String update(Class Classinfo){
		classInfoService.updateByPrimaryKey(Classinfo);
		return "redirect:/class/getAllClass";
	}
}
