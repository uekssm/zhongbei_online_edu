package org.bb.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bb.ssm.model.Team;
import org.bb.ssm.service.TeamInfoService;
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
@RequestMapping(value="/team")
public class TeamInfoCotroller {
	
	@Autowired
	private TeamInfoService teamInfoService;
	
	/**
	 * �û��б�ҳ
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(Map<String, Object> map){
		//List<Team> TeamList = TeamInfoService.findAll();
		//map.put("ALLTeam", TeamList);
		return "bui/acdemic/teamList";
	}
	
	/**
	 * �õ������û���Ϣ
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/getAllTeam",method=RequestMethod.POST)
	@ResponseBody
	public String getAllTeam(Object pageinfo,Map<String, Object> map){
		System.out.println(pageinfo);
		List<Team> TeamList = teamInfoService.findAll();
		
		HashMap<String,Object > tTeam = new HashMap<String,Object >();
		
		tTeam.put("rows", TeamList);
		tTeam.put("results", TeamList.size());
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsondata = mapper.writeValueAsString(tTeam);

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
	@RequestMapping(value="/addTeam",method= RequestMethod.GET)
	public String addTeam(Map<String, Object> map){
		//��Ϊҳ��ʹ��spring��form��ǩ����������modelAttribute��Ҫ����bean Ҫ���ᱨ��
		map.put("command", new Team());
		return "addTeam";
	}
	
	/**
	 * ����û�����
	 * @param Teaminfo
	 * @return
	 */
	@RequestMapping(value="/addTeam",method=RequestMethod.POST)
	public String save(Team Teaminfo){
		int result = teamInfoService.insert(Teaminfo);
		System.out.println("����û��Ĳ������Ϊ��"+result);
		return "redirect:/team/getAllTeam";
	}
	/**
	 * ɾ���û�����
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable(value="id") int id){
		int result = teamInfoService.deleteByPrimaryKey(id);
		System.out.println("ɾ���û��Ĳ������Ϊ��"+result+"���ݽ�����idΪ��"+id);
		return "redirect:/team/getAllTeam";
	}
	/**
	 * ����ǰ�ȸ���id�ҵ��û���Ϣ�����Ե�ҳ����
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/detail/{id}",method=RequestMethod.GET)
	public String input(@PathVariable(value="id") Integer id,Map<String, Object> map){
		map.put("command", teamInfoService.selectByPrimaryKey(id));
		return "addTeam";
	}
	
	@ModelAttribute
	public void getTeamInfo(@RequestParam(value="TeamId",required=false) Integer id
			,Map<String, Object> map){
		System.out.println("ÿ��controller ���������ȵ�����Ŷ");
		if(id != null){
			System.out.println("update ����");
			map.put("TeamInfo", teamInfoService.selectByPrimaryKey(id));
		}
		System.out.println("insert  ����");
	}
	
	@RequestMapping(value="/addTeam",method=RequestMethod.PUT)
	public String update(Team Teaminfo){
		teamInfoService.updateByPrimaryKey(Teaminfo);
		return "redirect:/team/getAllTeam";
	}
}
