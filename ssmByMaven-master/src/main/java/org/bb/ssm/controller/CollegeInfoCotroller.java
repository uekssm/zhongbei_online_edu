package org.bb.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bb.ssm.model.College;
import org.bb.ssm.service.CollegeInfoService;
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
@RequestMapping(value="/college")
public class CollegeInfoCotroller {
	
	@Autowired
	private CollegeInfoService collegeInfoService;
	
	/**
	 * ѧԺ�б�ҳ
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(Map<String, Object> map){
		//List<College> CollegeList = CollegeInfoService.findAll();
		//map.put("ALLCollege", CollegeList);
		return "bui/acdemic/collegeList";
	}
	
	/**
	 * �õ�����ѧԺ��Ϣ
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/getAllCollege",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String getAllCollege(@RequestParam(value="limit",required=false) Integer limit,@RequestParam(value="pageIndex",required=false) Integer pageIndex,@RequestParam(value="name",required=false) String name,@RequestParam(value="university_id",required=false) int university_id){
		pageIndex=pageIndex*limit;
		List<College> CollegeList = collegeInfoService.findAll(limit,pageIndex,name,university_id);
		
		HashMap<String,Object > tCollege = new HashMap<String,Object >();
		
		tCollege.put("rows", CollegeList);
		tCollege.put("results", collegeInfoService.totalCount(name,university_id));
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsondata = mapper.writeValueAsString(tCollege);

			//System.out.println(jsondata);
			
			return jsondata;
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * ͨ��handlerǰ�����ѧԺҳ��
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/addCollege",method= RequestMethod.GET)
	public String addCollege(Map<String, Object> map){
		//��Ϊҳ��ʹ��spring��form��ǩ����������modelAttribute��Ҫ����bean Ҫ���ᱨ��
		map.put("command", new College());
		return "redirect:/college/getAllCollege?limit=10&pageIndex=0&name=''&university_id=0";
	}
	
	/**
	 * ���ѧԺ����
	 * @param Collegeinfo
	 * @return
	 */
	@RequestMapping(value="/addCollege",method=RequestMethod.POST)
	public String save(College Collegeinfo){
		int result = collegeInfoService.insert(Collegeinfo);
		System.out.println("���ѧԺ�Ĳ������Ϊ��"+result);
		return "redirect:/college/getAllCollege?limit=10&pageIndex=0&name=''&university_id=0";
	}
	/**
	 * ɾ��ѧԺ����
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable(value="id") int id){
		int result = collegeInfoService.deleteByPrimaryKey(id);
		System.out.println("ɾ��ѧԺ�Ĳ������Ϊ��"+result+"���ݽ�����idΪ��"+id);
		return "redirect:/college/getAllCollege";
	}
	/**
	 * ����ǰ�ȸ���id�ҵ�ѧԺ��Ϣ�����Ե�ҳ����
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/detail/{id}",method=RequestMethod.GET)
	public String input(@PathVariable(value="id") Integer id,Map<String, Object> map){
		map.put("command", collegeInfoService.selectByPrimaryKey(id));
		return "addCollege";
	}
	
	@ModelAttribute
	public void getCollegeInfo(@RequestParam(value="CollegeId",required=false) Integer id
			,Map<String, Object> map){
		System.out.println("ÿ��controller ���������ȵ�����Ŷ");
		if(id != null){
			System.out.println("update ����");
			map.put("CollegeInfo", collegeInfoService.selectByPrimaryKey(id));
		}
		System.out.println("insert  ����");
	}
	
	@RequestMapping(value="/addCollege",method=RequestMethod.PUT)
	public String update(College Collegeinfo){
		collegeInfoService.updateByPrimaryKey(Collegeinfo);
		return "redirect:/college/getAllCollege";
	}
}
