package org.bb.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bb.ssm.model.Role;
import org.bb.ssm.model.FirstBase;
import org.bb.ssm.service.RoleInfoService;
import org.bb.ssm.service.FirstBaseInfoService;
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
@RequestMapping(value="/firstBase")
public class FirstBaseInfoCotroller {
	
	@Autowired
	private FirstBaseInfoService firstBaseInfoService;
	
	@Autowired
	private RoleInfoService roleInfoService;
	
	/**
	 * �û��б�ҳ
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(Map<String, Object> map){
		List<Role> roleList = roleInfoService.findAll(null, null, null);
		map.put("allrole", roleList);
		System.out.println(roleList);
		return "bui/system/firstBaseList";
	}
	
	/**
	 * �õ������û���Ϣ
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/getAllFirstBase",method=RequestMethod.POST)
	@ResponseBody
	public String getAllFirstBase(Object pageinfo,Map<String, Object> map){
		System.out.println(pageinfo);
		List<FirstBase> firstBaseList = firstBaseInfoService.findAll();
		
		HashMap<String,Object > tFirstBase = new HashMap<String,Object >();
		
		tFirstBase.put("rows", firstBaseList);
		tFirstBase.put("results", firstBaseList.size());
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsondata = mapper.writeValueAsString(tFirstBase);

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
	@RequestMapping(value="/addFirstBase",method= RequestMethod.GET)
	public String addFirstBase(Map<String, Object> map){
		//��Ϊҳ��ʹ��spring��form��ǩ����������modelAttribute��Ҫ����bean Ҫ���ᱨ��
		map.put("command", new FirstBase());
		return "addFirstBase";
	}
	
	/**
	 * ����û�����
	 * @param firstBaseinfo
	 * @return
	 */
	@RequestMapping(value="/addFirstBase",method=RequestMethod.POST)
	public String save(FirstBase firstBaseinfo){
		int result = firstBaseInfoService.insert(firstBaseinfo);
		System.out.println("����û��Ĳ������Ϊ��"+result);
		return "redirect:/firstBase/getAllFirstBase";
	}
	/**
	 * ɾ���û�����
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable(value="id") int id){
		int result = firstBaseInfoService.deleteByPrimaryKey(id);
		System.out.println("ɾ���û��Ĳ������Ϊ��"+result+"���ݽ�����idΪ��"+id);
		return "redirect:/firstBase/getAllFirstBase";
	}
	/**
	 * ����ǰ�ȸ���id�ҵ��û���Ϣ�����Ե�ҳ����
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/detail/{id}",method=RequestMethod.GET)
	public String input(@PathVariable(value="id") Integer id,Map<String, Object> map){
		map.put("command", firstBaseInfoService.selectByPrimaryKey(id));
		return "addFirstBase";
	}
	
	@ModelAttribute
	public void getFirstBaseInfo(@RequestParam(value="firstBaseId",required=false) Integer id
			,Map<String, Object> map){
		System.out.println("ÿ��controller ���������ȵ�����Ŷ");
		if(id != null){
			System.out.println("update ����");
			map.put("firstBaseInfo", firstBaseInfoService.selectByPrimaryKey(id));
		}
		System.out.println("insert  ����");
	}
	
	@RequestMapping(value="/addFirstBase",method=RequestMethod.PUT)
	public String update(FirstBase firstBaseinfo){
		firstBaseInfoService.updateByPrimaryKey(firstBaseinfo);
		return "redirect:/firstBase/getAllFirstBase";
	}
}
