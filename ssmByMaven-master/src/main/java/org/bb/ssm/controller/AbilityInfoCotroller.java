package org.bb.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bb.ssm.model.Ability;
import org.bb.ssm.service.AbilityInfoService;
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
@RequestMapping(value="/ability")
public class AbilityInfoCotroller {
	
	@Autowired
	private AbilityInfoService abilityInfoService;
	
	/**
	 * �û��б�ҳ
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(Map<String, Object> map){
		//List<Ability> AbilityList = AbilityInfoService.findAll();
		//map.put("ALLAbility", AbilityList);
		return "bui/acdemic/abilityList";
	}
	
	/**
	 * �õ������û���Ϣ
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/getAllAbility",method=RequestMethod.POST)
	@ResponseBody
	public String getAllAbility(Object pageinfo,Map<String, Object> map){
		System.out.println(pageinfo);
		List<Ability> AbilityList = abilityInfoService.findAll();
		
		HashMap<String,Object > tAbility = new HashMap<String,Object >();
		
		tAbility.put("rows", AbilityList);
		tAbility.put("results", AbilityList.size());
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsondata = mapper.writeValueAsString(tAbility);

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
	@RequestMapping(value="/addAbility",method= RequestMethod.GET)
	public String addAbility(Map<String, Object> map){
		//��Ϊҳ��ʹ��spring��form��ǩ����������modelAttribute��Ҫ����bean Ҫ���ᱨ��
		map.put("command", new Ability());
		return "addAbility";
	}
	
	/**
	 * ����û�����
	 * @param Abilityinfo
	 * @return
	 */
	@RequestMapping(value="/addAbility",method=RequestMethod.POST)
	public String save(Ability Abilityinfo){
		int result = abilityInfoService.insert(Abilityinfo);
		System.out.println("����û��Ĳ������Ϊ��"+result);
		return "redirect:/ability/getAllAbility";
	}
	/**
	 * ɾ���û�����
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable(value="id") int id){
		int result = abilityInfoService.deleteByPrimaryKey(id);
		System.out.println("ɾ���û��Ĳ������Ϊ��"+result+"���ݽ�����idΪ��"+id);
		return "redirect:/ability/getAllAbility";
	}
	/**
	 * ����ǰ�ȸ���id�ҵ��û���Ϣ�����Ե�ҳ����
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/detail/{id}",method=RequestMethod.GET)
	public String input(@PathVariable(value="id") Integer id,Map<String, Object> map){
		map.put("command", abilityInfoService.selectByPrimaryKey(id));
		return "addAbility";
	}
	
	@ModelAttribute
	public void getAbilityInfo(@RequestParam(value="AbilityId",required=false) Integer id
			,Map<String, Object> map){
		System.out.println("ÿ��controller ���������ȵ�����Ŷ");
		if(id != null){
			System.out.println("update ����");
			map.put("AbilityInfo", abilityInfoService.selectByPrimaryKey(id));
		}
		System.out.println("insert  ����");
	}
	
	@RequestMapping(value="/addAbility",method=RequestMethod.PUT)
	public String update(Ability Abilityinfo){
		abilityInfoService.updateByPrimaryKey(Abilityinfo);
		return "redirect:/ability/getAllAbility";
	}
}
