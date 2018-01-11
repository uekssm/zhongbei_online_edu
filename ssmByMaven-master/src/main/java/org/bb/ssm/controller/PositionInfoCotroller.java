package org.bb.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bb.ssm.model.Position;
import org.bb.ssm.service.PositionInfoService;
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
@RequestMapping(value="/position")
public class PositionInfoCotroller {
	
	@Autowired
	private PositionInfoService positionInfoService;
	
	/**
	 * �û��б�ҳ
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(Map<String, Object> map){
		//List<position> positionList = positionInfoService.findAll();
		//map.put("ALLposition", positionList);
		return "bui/organization/positionList";
	}
	
	/**
	 * �õ������û���Ϣ
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/getAllPosition",method=RequestMethod.POST)
	@ResponseBody
	public String getAllPosition(Object pageinfo,Map<String, Object> map){
		System.out.println(pageinfo);
		List<Position> positionList = positionInfoService.findAll();
		
		HashMap<String,Object > tposition = new HashMap<String,Object >();
		
		tposition.put("rows", positionList);
		tposition.put("results", positionList.size());
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsondata = mapper.writeValueAsString(tposition);

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
	@RequestMapping(value="/addposition",method= RequestMethod.GET)
	public String addposition(Map<String, Object> map){
		//��Ϊҳ��ʹ��spring��form��ǩ����������modelAttribute��Ҫ����bean Ҫ���ᱨ��
		map.put("command", new Position());
		return "addposition";
	}
	
	/**
	 * ����û�����
	 * @param positioninfo
	 * @return
	 */
	@RequestMapping(value="/addposition",method=RequestMethod.POST)
	public String save(Position positioninfo){
		int result = positionInfoService.insert(positioninfo);
		System.out.println("����û��Ĳ������Ϊ��"+result);
		return "redirect:/position/getAllPosition";
	}
	/**
	 * ɾ���û�����
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable(value="id") int id){
		int result = positionInfoService.deleteByPrimaryKey(id);
		System.out.println("ɾ���û��Ĳ������Ϊ��"+result+"���ݽ�����idΪ��"+id);
		return "redirect:/position/getAllPosition";
	}
	/**
	 * ����ǰ�ȸ���id�ҵ��û���Ϣ�����Ե�ҳ����
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/detail/{id}",method=RequestMethod.GET)
	public String input(@PathVariable(value="id") Integer id,Map<String, Object> map){
		map.put("command", positionInfoService.selectByPrimaryKey(id));
		return "addposition";
	}
	
	@ModelAttribute
	public void getpositionInfo(@RequestParam(value="positionId",required=false) Integer id
			,Map<String, Object> map){
		System.out.println("ÿ��controller ���������ȵ�����Ŷ");
		if(id != null){
			System.out.println("update ����");
			map.put("positionInfo", positionInfoService.selectByPrimaryKey(id));
		}
		System.out.println("insert  ����");
	}
	
	@RequestMapping(value="/addposition",method=RequestMethod.PUT)
	public String update(Position positioninfo){
		positionInfoService.updateByPrimaryKey(positioninfo);
		return "redirect:/position/getAllPosition";
	}
}
