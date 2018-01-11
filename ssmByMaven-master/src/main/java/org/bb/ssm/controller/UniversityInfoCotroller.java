package org.bb.ssm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.bb.ssm.model.University;
import org.bb.ssm.service.UniversityInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping(value="/university")
public class UniversityInfoCotroller {
	
	@Autowired
	private UniversityInfoService universityInfoService;
	
	/**
	 * �û��б�ҳ
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(Map<String, Object> map){
		//List<university> universityList = universityInfoService.findAll();
		//map.put("ALLuniversity", universityList);
		return "bui/acdemic/universityList";
	}

	
	
	/**
	 * �õ������û���Ϣ
	 * @param map
	 * @return
	 */
	
	@RequestMapping(value="/getAllUniversity",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String getAllUniversity(@RequestParam(value="limit",required=false) Integer limit,@RequestParam(value="pageIndex",required=false) Integer pageIndex,@RequestParam(value="searchname",required=false) String searchname){
		pageIndex=pageIndex*limit;
		List<University> universityList = universityInfoService.findAll(limit,pageIndex,searchname);
		
		HashMap<String,Object > tuniversity = new HashMap<String,Object >();
		
		tuniversity.put("rows", universityList);
		tuniversity.put("results", universityInfoService.totalCount(searchname));
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsondata = mapper.writeValueAsString(tuniversity);

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
	/*@RequestMapping(value="/adduniversity",method= RequestMethod.GET)
	public String adduniversity(Map<String, Object> map){
		//��Ϊҳ��ʹ��spring��form��ǩ����������modelAttribute��Ҫ����bean Ҫ���ᱨ��
		map.put("command", new University());
		return "adduniversity";
	}*/
	
	/**
	 * ���ѧУ����
	 * @param universityinfo
	 * @return
	 */
	@RequestMapping(value="/adduniversity",method=RequestMethod.POST)
	public String save(University universityinfo){
		//int result = universityInfoService.insert(universityinfo);
		universityInfoService.insert(universityinfo);
		//System.out.println("���ѧУ�Ĳ������Ϊ��"+result);
		return "redirect:/university/getAllUniversity?limit=10&pageIndex=0&searchname=''";
	}
	/**
	 * ɾ���û�����
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String delete(@RequestParam(value="ids[]") String[] ids){
		
		universityInfoService.deleteByPrimaryKey(ids);
		return "redirect:/university/getAllUniversity?limit=10&pageIndex=0&searchname=''";
	}
	/**
	 * ����ǰ�ȸ���id�ҵ��û���Ϣ�����Ե�ҳ����
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/detail/{id}",method=RequestMethod.GET)
	public String input(@PathVariable(value="id") Integer id,Map<String, Object> map){
		map.put("command", universityInfoService.selectByPrimaryKey(id));
		return "adduniversity";
	}
	
	@ModelAttribute
	public void getuniversityInfo(@RequestParam(value="universityId",required=false) Integer id
			,Map<String, Object> map){
		System.out.println("ÿ��controller ���������ȵ�����Ŷ");
		if(id != null){
			System.out.println("update ����");
			map.put("universityInfo", universityInfoService.selectByPrimaryKey(id));
		}
		System.out.println("insert  ����");
	}
	
	@RequestMapping(value="/updateuniversity",method=RequestMethod.POST)
	public String update(University universityinfo){
		universityInfoService.updateByPrimaryKey(universityinfo);
		return "redirect:/university/getAllUniversity";
	}
}
