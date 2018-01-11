package org.bb.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bb.ssm.model.Titles;
import org.bb.ssm.service.TitlesInfoService;
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
@RequestMapping(value="/titles")
public class TitlesInfoCotroller {
	
	@Autowired
	private TitlesInfoService titlesInfoService;
	
	/**
	 * �û��б�ҳ
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(Map<String, Object> map){
		//List<Titles> TitlesList = TitlesInfoService.findAll();
		//map.put("ALLTitles", TitlesList);
		return "bui/acdemic/titlesList";
	}
	
	/**
	 * �õ������û���Ϣ
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/getAllTitles",method=RequestMethod.POST)
	@ResponseBody
	public String getAllTitles(Object pageinfo,Map<String, Object> map){
		System.out.println(pageinfo);
		List<Titles> TitlesList = titlesInfoService.findAll();
		
		HashMap<String,Object > tTitles = new HashMap<String,Object >();
		
		tTitles.put("rows", TitlesList);
		tTitles.put("results", TitlesList.size());
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsondata = mapper.writeValueAsString(tTitles);

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
	@RequestMapping(value="/addTitles",method= RequestMethod.GET)
	public String addTitles(Map<String, Object> map){
		//��Ϊҳ��ʹ��spring��form��ǩ����������modelAttribute��Ҫ����bean Ҫ���ᱨ��
		map.put("command", new Titles());
		return "addTitles";
	}
	
	/**
	 * ����û�����
	 * @param Titlesinfo
	 * @return
	 */
	@RequestMapping(value="/addTitles",method=RequestMethod.POST)
	public String save(Titles Titlesinfo){
		int result = titlesInfoService.insert(Titlesinfo);
		System.out.println("����û��Ĳ������Ϊ��"+result);
		return "redirect:/titles/getAllTitles";
	}
	/**
	 * ɾ���û�����
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable(value="id") int id){
		int result = titlesInfoService.deleteByPrimaryKey(id);
		System.out.println("ɾ���û��Ĳ������Ϊ��"+result+"���ݽ�����idΪ��"+id);
		return "redirect:/titles/getAllTitles";
	}
	/**
	 * ����ǰ�ȸ���id�ҵ��û���Ϣ�����Ե�ҳ����
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/detail/{id}",method=RequestMethod.GET)
	public String input(@PathVariable(value="id") Integer id,Map<String, Object> map){
		map.put("command", titlesInfoService.selectByPrimaryKey(id));
		return "addTitles";
	}
	
	@ModelAttribute
	public void getTitlesInfo(@RequestParam(value="TitlesId",required=false) Integer id
			,Map<String, Object> map){
		System.out.println("ÿ��controller ���������ȵ�����Ŷ");
		if(id != null){
			System.out.println("update ����");
			map.put("TitlesInfo", titlesInfoService.selectByPrimaryKey(id));
		}
		System.out.println("insert  ����");
	}
	
	@RequestMapping(value="/addTitles",method=RequestMethod.PUT)
	public String update(Titles Titlesinfo){
		titlesInfoService.updateByPrimaryKey(Titlesinfo);
		return "redirect:/titles/getAllTitles";
	}
}
