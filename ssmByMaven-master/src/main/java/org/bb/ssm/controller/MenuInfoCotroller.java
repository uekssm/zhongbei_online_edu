package org.bb.ssm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.bb.ssm.model.Menu;
import org.bb.ssm.service.MenuInfoService;
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
@RequestMapping(value = "/menu")
public class MenuInfoCotroller {

	@Autowired
	private MenuInfoService menuInfoService;

	/**
	 * �˵��б�ҳ
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(Map<String, Object> map){
		//List<User> userList = userInfoService.findAll();
		//map.put("ALLUSER", userList);
		return "bui/system/menuList";
	}
	
	/**
	 * �õ������Ӽ��˵���Ϣ
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/getMenus" )
	@ResponseBody
	public String getMenus(HttpServletRequest request) {
		List<Menu> menuList = menuInfoService.findAll();
		

		/*HashMap<String , String> tMenu1 = new HashMap<String , String>();
		tMenu1.put("id" , "main-menu");
		tMenu1.put("text" , "��������");
		tMenu1.put("href" , "href");
		
		List<HashMap<String , String>> list = new ArrayList<HashMap<String , String>>();
		
		list.add(tMenu1);
		
		HashMap<String , Object> tMenu2 = new HashMap<String , Object>();
		tMenu2.put("text", "��ҳ����");
		tMenu2.put("items", list);
		
		List<Map> list2 = new ArrayList<Map>();
		list2.add(tMenu2);
		
		HashMap<String , Object> tMenu3 = new HashMap<String , Object>();
		tMenu3.put("id", "menu");
		tMenu3.put("menu", list2);*/
		
		List<Map> list3 = new ArrayList<Map>();
		for (Menu menus : menuList) {
			HashMap<String , Object> tMenu3 = new HashMap<String , Object>();
			if(menus.getParent_id()==null){
				tMenu3.put("id", menus.getId());
				
				List<Map> list2 = new ArrayList<Map>();
				for (Menu menus1 : menuList) {
					HashMap<String , Object> tMenu2 = new HashMap<String , Object>();
					if (menus1.getParent_id()==menus.getId()) {
						tMenu2.put("text", menus1.getName());
						tMenu2.put("collapsed", menus1.getName());
						List<HashMap<String , String>> list = new ArrayList<HashMap<String , String>>();
						for (Menu menus2 : menuList) {
							HashMap<String , String> tMenu1 = new HashMap<String , String>();
							
							//System.out.println(menus2.getParent_id());
							//System.out.println(menus1.getId());
							
							//System.out.println(menus2.getParent_id()==menus1.getId());
							if(menus2.getParent_id()==menus1.getId()){
								//System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
								tMenu1.put("id" , ""+menus2.getId());
								tMenu1.put("text" ,menus2.getName());
								tMenu1.put("href" , request.getContextPath()+"/"+menus2.getTarget_href());
								//System.out.println(tMenu1);
								list.add(tMenu1);
							}
							
						}
						tMenu2.put("items", list);
						
						list2.add(tMenu2);
					}
					
				}
				tMenu3.put("menu", list2);
				
				list3.add(tMenu3);
			}
			
		}
		
//		return tMenu3;
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsondata = mapper.writeValueAsString(list3);

			System.out.println(jsondata);
			
			return jsondata;
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * �õ����β˵�
	 * �����޸�ѡ�񸸲˵���ֻҪǰ�����˵�
	 * 
	 * @return
	 */
	@RequestMapping(value = "/tree" )
	@ResponseBody
	public String tree(HttpServletRequest request) {
		List<Menu> menuList = menuInfoService.findAll();
	
		List<Map> list3 = new ArrayList<Map>();
		for (Menu menus : menuList) {
			HashMap<String , Object> tMenu3 = new HashMap<String , Object>();
			if(menus.getParent_id()==null){
				tMenu3.put("id", menus.getId());
				tMenu3.put("text", menus.getName());
				
				List<Map> list2 = new ArrayList<Map>();
				for (Menu menus1 : menuList) {
					HashMap<String , Object> tMenu2 = new HashMap<String , Object>();
					if (menus1.getParent_id()==menus.getId()) {
						tMenu2.put("text", menus1.getName());
						tMenu2.put("id", menus1.getId());
						list2.add(tMenu2);
					}
					
				}
				tMenu3.put("children", list2);
				
				list3.add(tMenu3);
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
	 * �õ����β˵�
	 * ��ɫ�󶨲˵�����Ҫȫ���˵�
	 * 
	 * @return
	 */
	@RequestMapping(value = "/trees" )
	@ResponseBody
	public String trees(HttpServletRequest request) {
		List<Menu> menuList = menuInfoService.findAll();
	
		List<Map> list3 = new ArrayList<Map>();
		for (Menu menus : menuList) {
			HashMap<String , Object> tMenu3 = new HashMap<String , Object>();
			if(menus.getParent_id()==null){
				tMenu3.put("id", menus.getId());
				tMenu3.put("text", menus.getName());
				
				List<Map> list2 = new ArrayList<Map>();
				for (Menu menus1 : menuList) {
					HashMap<String , Object> tMenu2 = new HashMap<String , Object>();
					if (menus1.getParent_id()==menus.getId()) {
						tMenu2.put("text", menus1.getName());
						tMenu2.put("id", menus1.getId());
						
						List<Map> list = new ArrayList<Map>();
						for (Menu menus2 : menuList) {
							HashMap<String , Object> tMenu = new HashMap<String , Object>();
							if (menus2.getParent_id()==menus1.getId()) {
								tMenu.put("text", menus2.getName());
								tMenu.put("id", menus2.getId());
								list.add(tMenu);
							}
							
						}
						tMenu2.put("children", list);
						
						list2.add(tMenu2);
					}
					
				}
				tMenu3.put("children", list2);
				
				list3.add(tMenu3);
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
	 * �õ��б�
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/getPageMenu",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String getPageMenu(@RequestParam(value="limit",required=false) Integer limit,@RequestParam(value="pageIndex",required=false) Integer pageIndex,@RequestParam(value="searchname",required=false) String searchname,@RequestParam(value="url",required=false) String url) {
		pageIndex=pageIndex*limit;
		List<Menu> menuList = menuInfoService.findAllByPage(limit,pageIndex,searchname,url);
		
		HashMap<String,Object > tUser = new HashMap<String,Object >();
		
		tUser.put("rows", menuList);
		tUser.put("results", menuInfoService.totalCount(searchname,url));
		
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
	 * ͨ��handlerǰ����Ӳ˵�ҳ��
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/addMenu", method = RequestMethod.GET)
	public String addMenu(Map<String, Object> map) {
		// ��Ϊҳ��ʹ��spring��form��ǩ����������modelAttribute��Ҫ����bean Ҫ���ᱨ��
		map.put("command", new Menu());
		return "addMenu";
	}

	/**
	 * ��Ӳ˵�����
	 * 
	 * @param menuinfo
	 * @return
	 */
	@RequestMapping(value = "/addMenu", method = RequestMethod.POST)
	public String save(Menu menuinfo) {
		int result = menuInfoService.insert(menuinfo);
		System.out.println("��Ӳ˵��Ĳ������Ϊ��" + result);
		return "redirect:/menu/getPageMenu?limit=10&pageIndex=0&searchname=null&url=null";
	}

	/**
	 * ɾ���˵�����
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable(value = "id") int id) {
		int result = menuInfoService.deleteByPrimaryKey(id);
		System.out.println("ɾ���˵��Ĳ������Ϊ��" + result + "���ݽ�����idΪ��" + id);
		System.out.println("***************************************");
		return "redirect:/menu/getPageMenu?limit=10&pageIndex=0&searchname=null&url=null";
	}

	/**
	 * ����ǰ�ȸ���id�ҵ��˵���Ϣ�����Ե�ҳ����
	 * 
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	public String input(@PathVariable(value = "id") Integer id,
			Map<String, Object> map) {
		map.put("command", menuInfoService.selectByPrimaryKey(id));
		return "addMenu";
	}

	@ModelAttribute
	public void getMenuInfo(
			@RequestParam(value = "menuId", required = false) Integer id,
			Map<String, Object> map) {
		System.out.println("ÿ��controller ���������ȵ�����Ŷ");
		if (id != null) {
			System.out.println("update ����");
			map.put("menuInfo", menuInfoService.selectByPrimaryKey(id));
		}
		System.out.println("insert  ����");
	}

	@RequestMapping(value = "/addMenu", method = RequestMethod.PUT)
	public String update(Menu menuinfo) {
		menuInfoService.updateByPrimaryKey(menuinfo);
		return "redirect:/menu/getPageMenu?limit=10&pageIndex=0&searchname=null&url=null";
	}
}
