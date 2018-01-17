package org.bb.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bb.ssm.model.FirstBase;
import org.bb.ssm.model.Role;
import org.bb.ssm.model.User;
import org.bb.ssm.service.FirstBaseInfoService;
import org.bb.ssm.service.RoleInfoService;
import org.bb.ssm.service.UserInfoService;
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
@RequestMapping(value="/user")
public class UserInfoCotroller {
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private RoleInfoService roleInfoService;
	
	@Autowired
	private FirstBaseInfoService firstBaseInfoService;
	
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
		return "bui/system/userList";
	}
	
	/**
	 * �õ������û���Ϣ
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/getAllUser",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String getAllUser(@RequestParam(value="limit",required=false) Integer limit,@RequestParam(value="pageIndex",required=false) Integer pageIndex,@RequestParam(value="searchname",required=false) String searchname,@RequestParam(value="status",required=false) Integer status){
		pageIndex=pageIndex*limit;
		List<User> userList = userInfoService.findAll(limit,pageIndex,searchname,status);
		
		HashMap<String,Object > tUser = new HashMap<String,Object >();
		
		tUser.put("rows", userList);
		tUser.put("results", userInfoService.totalCount(searchname,status));
		
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
	@RequestMapping(value="/addUser",method= RequestMethod.GET)
	public String addUser(Map<String, Object> map){
		//��Ϊҳ��ʹ��spring��form��ǩ����������modelAttribute��Ҫ����bean Ҫ���ᱨ��
		map.put("command", new User());
		return "addUser";
	}
	
	@RequestMapping(value="/bind_Roles",method= {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String bindRoles(@RequestParam(value="user_id",required=false) Integer user_id,@RequestParam(value="role_ids",required=false) String role_ids){
		String[] roleids=role_ids.split(",");
		//�������н�ɫ�����ΰ�,��֮ǰɾ�����û�ԭ���İ���Ϣ
		firstBaseInfoService.deleteByUserid(user_id);
		for (int i = 0; i < roleids.length; i++) {
			FirstBase userrole=new FirstBase();
			userrole.setUser_id(user_id);
			userrole.setRole_id(Integer.parseInt(roleids[i]));
			firstBaseInfoService.insert(userrole);
		}
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsondata = mapper.writeValueAsString(roleids);

			return jsondata;
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * ����û�����
	 * @param userinfo
	 * @return
	 */
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public String save(User userinfo){
		int result = userInfoService.insert(userinfo);
		System.out.println("����û��Ĳ������Ϊ��"+result);
		return "redirect:/user/getAllUser";
	}
	/**
	 * ɾ���û�����
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable(value="id") int id){
		int result = userInfoService.deleteByPrimaryKey(id);
		System.out.println("ɾ���û��Ĳ������Ϊ��"+result+"���ݽ�����idΪ��"+id);
		return "redirect:/user/getAllUser";
	}
	/**
	 * ����ǰ�ȸ���id�ҵ��û���Ϣ�����Ե�ҳ����
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/detail/{id}",method=RequestMethod.GET)
	public String input(@PathVariable(value="id") Integer id,Map<String, Object> map){
		map.put("command", userInfoService.selectByPrimaryKey(id));
		return "addUser";
	}
	
	@ModelAttribute
	public void getUserInfo(@RequestParam(value="userId",required=false) Integer id
			,Map<String, Object> map){
		System.out.println("ÿ��controller ���������ȵ�����Ŷ");
		if(id != null){
			System.out.println("update ����");
			map.put("userInfo", userInfoService.selectByPrimaryKey(id));
		}
		System.out.println("insert  ����");
	}
	
	@RequestMapping(value="/addUser",method=RequestMethod.PUT)
	public String update(User userinfo){
		userInfoService.updateByPrimaryKey(userinfo);
		return "redirect:/user/getAllUser";
	}
}
