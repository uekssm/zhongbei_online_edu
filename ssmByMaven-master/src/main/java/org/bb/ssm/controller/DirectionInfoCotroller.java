package org.bb.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bb.ssm.model.Direction;
import org.bb.ssm.service.DirectionInfoService;
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
@RequestMapping(value="/direction")
public class DirectionInfoCotroller {
	
	@Autowired
	private DirectionInfoService directionInfoService;
	
	/**
	 * �û��б�ҳ
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(Map<String, Object> map){
		//List<direction> directionList = directionInfoService.findAll();
		//map.put("ALLdirection", directionList);
		return "bui/acdemic/directionList";
	}
	
	/**
	 * �õ������û���Ϣ
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/getAllDirection",method=RequestMethod.POST)
	@ResponseBody
	public String getAllDirection(Object pageinfo,Map<String, Object> map){
		System.out.println(pageinfo);
		List<Direction> directionList = directionInfoService.findAll();
		
		HashMap<String,Object > tdirection = new HashMap<String,Object >();
		
		tdirection.put("rows", directionList);
		tdirection.put("results", directionList.size());
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsondata = mapper.writeValueAsString(tdirection);

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
	@RequestMapping(value="/adddirection",method= RequestMethod.GET)
	public String adddirection(Map<String, Object> map){
		//��Ϊҳ��ʹ��spring��form��ǩ����������modelAttribute��Ҫ����bean Ҫ���ᱨ��
		map.put("command", new Direction());
		return "adddirection";
	}
	
	/**
	 * ����û�����
	 * @param directioninfo
	 * @return
	 */
	@RequestMapping(value="/adddirection",method=RequestMethod.POST)
	public String save(Direction directioninfo){
		int result = directionInfoService.insert(directioninfo);
		System.out.println("����û��Ĳ������Ϊ��"+result);
		return "redirect:/direction/getAllDirection";
	}
	/**
	 * ɾ���û�����
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable(value="id") int id){
		int result = directionInfoService.deleteByPrimaryKey(id);
		System.out.println("ɾ���û��Ĳ������Ϊ��"+result+"���ݽ�����idΪ��"+id);
		return "redirect:/direction/getAllDirection";
	}
	/**
	 * ����ǰ�ȸ���id�ҵ��û���Ϣ�����Ե�ҳ����
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/detail/{id}",method=RequestMethod.GET)
	public String input(@PathVariable(value="id") Integer id,Map<String, Object> map){
		map.put("command", directionInfoService.selectByPrimaryKey(id));
		return "adddirection";
	}
	
	@ModelAttribute
	public void getdirectionInfo(@RequestParam(value="directionId",required=false) Integer id
			,Map<String, Object> map){
		System.out.println("ÿ��controller ���������ȵ�����Ŷ");
		if(id != null){
			System.out.println("update ����");
			map.put("directionInfo", directionInfoService.selectByPrimaryKey(id));
		}
		System.out.println("insert  ����");
	}
	
	@RequestMapping(value="/adddirection",method=RequestMethod.PUT)
	public String update(Direction directioninfo){
		directionInfoService.updateByPrimaryKey(directioninfo);
		return "redirect:/direction/getAllDirection";
	}
}
