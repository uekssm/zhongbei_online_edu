package org.bb.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bb.ssm.model.Role;
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
@RequestMapping(value="/role")
public class RoleInfoCotroller {
	
	@Autowired
	private RoleInfoService roleInfoService;
	
	/**
	 * ��ɫ�б�ҳ
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(Map<String, Object> map){
		//List<User> userList = userInfoService.findAll();
		//map.put("ALLUSER", userList);
		return "bui/system/roleList";
	}
	
	/**
	 * �õ������û���Ϣ
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/getAllRole")
	@ResponseBody
	public String getAllRole(Map<String, Object> map){
		List<Role> roleList = roleInfoService.findAll();
		HashMap<String,Object > tUser = new HashMap<String,Object >();
		
		tUser.put("rows", roleList);
		tUser.put("results", roleList.size());
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsondata = mapper.writeValueAsString(tUser);

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
	@RequestMapping(value="/addRole",method= RequestMethod.GET)
	public String addRole(Map<String, Object> map){
		//��Ϊҳ��ʹ��spring��form��ǩ����������modelAttribute��Ҫ����bean Ҫ���ᱨ��
		map.put("command", new Role());
		return "addRole";
	}
	
	/**
	 * ����û�����
	 * @param roleinfo
	 * @return
	 */
	@RequestMapping(value="/addRole",method=RequestMethod.POST)
	public String save(Role roleinfo){
		int result = roleInfoService.insert(roleinfo);
		System.out.println("����û��Ĳ������Ϊ��"+result);
		return "redirect:/role/getAllRole";
	}
	/**
	 * ɾ���û�����
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable(value="id") int id){
		int result = roleInfoService.deleteByPrimaryKey(id);
		System.out.println("ɾ���û��Ĳ������Ϊ��"+result+"���ݽ�����idΪ��"+id);
		return "redirect:/role/getAllRole";
	}
	/**
	 * ����ǰ�ȸ���id�ҵ��û���Ϣ�����Ե�ҳ����
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/detail/{id}",method=RequestMethod.GET)
	public String input(@PathVariable(value="id") Integer id,Map<String, Object> map){
		map.put("command", roleInfoService.selectByPrimaryKey(id));
		return "addRole";
	}
	
	@ModelAttribute
	public void getRoleInfo(@RequestParam(value="roleId",required=false) Integer id
			,Map<String, Object> map){
		System.out.println("ÿ��controller ���������ȵ�����Ŷ");
		if(id != null){
			System.out.println("update ����");
			map.put("roleInfo", roleInfoService.selectByPrimaryKey(id));
		}
		System.out.println("insert  ����");
	}
	
	@RequestMapping(value="/addRole",method=RequestMethod.PUT)
	public String update(Role roleinfo){
		roleInfoService.updateByPrimaryKey(roleinfo);
		return "redirect:/role/getAllRole";
	}
}
