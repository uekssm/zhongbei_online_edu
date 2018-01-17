package org.bb.ssm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.bb.ssm.model.Position;
import org.bb.ssm.model.Role;
import org.bb.ssm.service.PositionInfoService;
import org.bb.ssm.service.RoleInfoService;
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
	
	@Autowired
	private RoleInfoService roleInfoService;
	
	/**
	 * ְλ�б�ҳ
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
	 * �õ�����ְλ��Ϣ
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/getAllPosition",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String getAllPosition(@RequestParam(value="limit",required=false) Integer limit,@RequestParam(value="pageIndex",required=false) Integer pageIndex,@RequestParam(value="searchname",required=false) String searchname,@RequestParam(value="department_id",required=false) Integer department_id){
		pageIndex=pageIndex*limit;
		List<Position> positionList = positionInfoService.findAll(limit,pageIndex,searchname,department_id);
		
		HashMap<String,Object > tposition = new HashMap<String,Object >();
		
		tposition.put("rows", positionList);
		tposition.put("results", positionInfoService.totalCount(searchname,department_id));
		
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
	 * �õ�����ְλ
	 * 
	 * @return
	 */
	@RequestMapping(value = "/tree" )
	@ResponseBody
	public String tree(HttpServletRequest request) {
		List<Position> positionList = positionInfoService.findAll(null, null, null, null);
		List<Map> list3 = new ArrayList<Map>();
		for (Position positions : positionList) {
			HashMap<String , Object> tPosition3 = new HashMap<String , Object>();
			if(positions.getParent_id()==null||positions.getParent_id()==0){
				tPosition3.put("id", positions.getId());
				tPosition3.put("text", positions.getName());
				
				List<Map> list2 = new ArrayList<Map>();
				for (Position positions1 : positionList) {
					HashMap<String , Object> tPosition2 = new HashMap<String , Object>();
					if (positions1.getParent_id()==positions.getId()) {
						tPosition2.put("text", positions1.getName());
						tPosition2.put("id", positions1.getId());
						
						List<Map> list = new ArrayList<Map>();
						for (Position positions2 : positionList) {
							HashMap<String , Object> tPosition = new HashMap<String , Object>();
							if (positions2.getParent_id()==positions1.getId()) {
								System.out.println("----------------==================");
								tPosition.put("text", positions2.getName());
								tPosition.put("id", positions2.getId());
								list.add(tPosition);
								System.out.println(list);
							}
							
						}
						tPosition2.put("children", list);
						
						list2.add(tPosition2);
					}
					
				}
				tPosition3.put("children", list2);
				
				list3.add(tPosition3);
			}
			
		}
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsondata = mapper.writeValueAsString(list3);
			return jsondata;
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * ���ְλ����
	 * @param positioninfo
	 * @return
	 */
	@RequestMapping(value="/addposition",method=RequestMethod.POST)
	public String save(Position positioninfo){
		//����ְλǰ�Ƚ�ְλ������ְ������ɫ���У��ٽ��µĽ�ɫidһ������
		Role role=new Role();
		role.setAbout(positioninfo.getDuty());
		role.setName(positioninfo.getName());
		int newroleid=roleInfoService.insert(role);
		positioninfo.setRole_id(newroleid);
		int result = positionInfoService.insert(positioninfo);
		return "redirect:/position/getAllPosition?limit=10&pageIndex=0&searchname=null&department_id=0";
	}
	/**
	 * ɾ��ְλ����
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable(value="id") int id){
		int result = positionInfoService.deleteByPrimaryKey(id);
		System.out.println("ɾ��ְλ�Ĳ������Ϊ��"+result+"���ݽ�����idΪ��"+id);
		return "redirect:/position/getAllPosition?limit=10&pageIndex=0&searchname=null&department_id=null";
	}
	/**
	 * ����ǰ�ȸ���id�ҵ�ְλ��Ϣ�����Ե�ҳ����
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
	
	
}
