package org.bb.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bb.ssm.model.Indicators;
import org.bb.ssm.service.IndicatorsInfoService;
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
@RequestMapping(value="/indicators")
public class IndicatorsInfoCotroller {
	
	@Autowired
	private IndicatorsInfoService indicatorsInfoService;
	
	/**
	 * �û��б�ҳ
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(Map<String, Object> map){
		//List<Indicators> IndicatorsList = IndicatorsInfoService.findAll();
		//map.put("ALLIndicators", IndicatorsList);
		return "bui/acdemic/indicatorsList";
	}
	
	/**
	 * �õ������û���Ϣ
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/getAllIndicators",method=RequestMethod.POST)
	@ResponseBody
	public String getAllIndicators(Object pageinfo,Map<String, Object> map){
		System.out.println(pageinfo);
		List<Indicators> IndicatorsList = indicatorsInfoService.findAll();
		
		HashMap<String,Object > tIndicators = new HashMap<String,Object >();
		
		tIndicators.put("rows", IndicatorsList);
		tIndicators.put("results", IndicatorsList.size());
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsondata = mapper.writeValueAsString(tIndicators);

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
	@RequestMapping(value="/addIndicators",method= RequestMethod.GET)
	public String addIndicators(Map<String, Object> map){
		//��Ϊҳ��ʹ��spring��form��ǩ����������modelAttribute��Ҫ����bean Ҫ���ᱨ��
		map.put("command", new Indicators());
		return "addIndicators";
	}
	
	/**
	 * ����û�����
	 * @param Indicatorsinfo
	 * @return
	 */
	@RequestMapping(value="/addIndicators",method=RequestMethod.POST)
	public String save(Indicators Indicatorsinfo){
		int result = indicatorsInfoService.insert(Indicatorsinfo);
		System.out.println("����û��Ĳ������Ϊ��"+result);
		return "redirect:/indicators/getAllIndicators";
	}
	/**
	 * ɾ���û�����
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable(value="id") int id){
		int result = indicatorsInfoService.deleteByPrimaryKey(id);
		System.out.println("ɾ���û��Ĳ������Ϊ��"+result+"���ݽ�����idΪ��"+id);
		return "redirect:/indicators/getAllIndicators";
	}
	/**
	 * ����ǰ�ȸ���id�ҵ��û���Ϣ�����Ե�ҳ����
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/detail/{id}",method=RequestMethod.GET)
	public String input(@PathVariable(value="id") Integer id,Map<String, Object> map){
		map.put("command", indicatorsInfoService.selectByPrimaryKey(id));
		return "addIndicators";
	}
	
	@ModelAttribute
	public void getIndicatorsInfo(@RequestParam(value="IndicatorsId",required=false) Integer id
			,Map<String, Object> map){
		System.out.println("ÿ��controller ���������ȵ�����Ŷ");
		if(id != null){
			System.out.println("update ����");
			map.put("IndicatorsInfo", indicatorsInfoService.selectByPrimaryKey(id));
		}
		System.out.println("insert  ����");
	}
	
	@RequestMapping(value="/addIndicators",method=RequestMethod.PUT)
	public String update(Indicators Indicatorsinfo){
		indicatorsInfoService.updateByPrimaryKey(Indicatorsinfo);
		return "redirect:/indicators/getAllIndicators";
	}
}
