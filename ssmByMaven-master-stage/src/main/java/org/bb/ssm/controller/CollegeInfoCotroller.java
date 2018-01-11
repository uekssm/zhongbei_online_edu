package org.bb.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bb.ssm.model.College;
import org.bb.ssm.service.CollegeInfoService;
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
@RequestMapping(value="/college")
public class CollegeInfoCotroller {
	
	@Autowired
	private CollegeInfoService collegeInfoService;
	
	/**
	 * �û��б�ҳ
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(Map<String, Object> map){
		//List<College> CollegeList = CollegeInfoService.findAll();
		//map.put("ALLCollege", CollegeList);
		return "bui/acdemic/collegeList";
	}
	
	/**
	 * �õ������û���Ϣ
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/getAllCollege",method=RequestMethod.POST)
	@ResponseBody
	public String getAllCollege(Object pageinfo,Map<String, Object> map){
		System.out.println(pageinfo);
		List<College> CollegeList = collegeInfoService.findAll();
		
		HashMap<String,Object > tCollege = new HashMap<String,Object >();
		
		tCollege.put("rows", CollegeList);
		tCollege.put("results", CollegeList.size());
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsondata = mapper.writeValueAsString(tCollege);

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
	@RequestMapping(value="/addCollege",method= RequestMethod.GET)
	public String addCollege(Map<String, Object> map){
		//��Ϊҳ��ʹ��spring��form��ǩ����������modelAttribute��Ҫ����bean Ҫ���ᱨ��
		map.put("command", new College());
		return "addCollege";
	}
	
	/**
	 * ����û�����
	 * @param Collegeinfo
	 * @return
	 */
	@RequestMapping(value="/addCollege",method=RequestMethod.POST)
	public String save(College Collegeinfo){
		int result = collegeInfoService.insert(Collegeinfo);
		System.out.println("����û��Ĳ������Ϊ��"+result);
		return "redirect:/college/getAllCollege";
	}
	/**
	 * ɾ���û�����
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable(value="id") int id){
		int result = collegeInfoService.deleteByPrimaryKey(id);
		System.out.println("ɾ���û��Ĳ������Ϊ��"+result+"���ݽ�����idΪ��"+id);
		return "redirect:/college/getAllCollege";
	}
	/**
	 * ����ǰ�ȸ���id�ҵ��û���Ϣ�����Ե�ҳ����
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/detail/{id}",method=RequestMethod.GET)
	public String input(@PathVariable(value="id") Integer id,Map<String, Object> map){
		map.put("command", collegeInfoService.selectByPrimaryKey(id));
		return "addCollege";
	}
	
	@ModelAttribute
	public void getCollegeInfo(@RequestParam(value="CollegeId",required=false) Integer id
			,Map<String, Object> map){
		System.out.println("ÿ��controller ���������ȵ�����Ŷ");
		if(id != null){
			System.out.println("update ����");
			map.put("CollegeInfo", collegeInfoService.selectByPrimaryKey(id));
		}
		System.out.println("insert  ����");
	}
	
	@RequestMapping(value="/addCollege",method=RequestMethod.PUT)
	public String update(College Collegeinfo){
		collegeInfoService.updateByPrimaryKey(Collegeinfo);
		return "redirect:/college/getAllCollege";
	}
}
