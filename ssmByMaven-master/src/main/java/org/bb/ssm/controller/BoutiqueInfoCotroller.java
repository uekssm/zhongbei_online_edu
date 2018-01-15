package org.bb.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bb.ssm.model.Boutique;
import org.bb.ssm.service.BoutiqueInfoService;
import org.bb.ssm.service.CollegeInfoService;
import org.bb.ssm.service.CourseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
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
@RequestMapping(value="/boutique")
public class BoutiqueInfoCotroller {
	
	@Autowired
	private BoutiqueInfoService boutiqueInfoService;
	@Autowired
	private CollegeInfoService collegeInfoService;
	@Autowired
	private CourseInfoService courseInfoService;
	/**
	 * �ҵĿγ��б�ҳ
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/courselist")
	public String courselist(Map<String, Object> map){
		//List<Boutique> BoutiqueList = BoutiqueInfoService.findAll();
		//map.put("ALLBoutique", BoutiqueList);
		return "bui/acdemic/boutiqueMine";
	}
	
	/**
	 * ��Ʒ�γ�����б�ҳ
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/examinelist")
	public String examinelist(Map<String, Object> map){
		//List<Boutique> BoutiqueList = BoutiqueInfoService.findAll();
		//map.put("ALLBoutique", BoutiqueList);
		return "bui/acdemic/boutiqueExamine";
	}
	
	/**
	 * �õ������û���Ϣ
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/getAllBoutique",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String getAllBoutique(Object pageinfo,Map<String, Object> map){
		System.out.println(pageinfo);
		List<Boutique> BoutiqueList = boutiqueInfoService.findAll();
		
		HashMap<String,Object > tBoutique = new HashMap<String,Object >();
		
		tBoutique.put("rows", BoutiqueList);
		tBoutique.put("results", BoutiqueList.size());
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsondata = mapper.writeValueAsString(tBoutique);

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
	@RequestMapping(value="/apply",method= RequestMethod.GET)
	public String addBoutique(Map<String, Object> map){
		//��Ϊҳ��ʹ��spring��form��ǩ����������modelAttribute��Ҫ����bean Ҫ���ᱨ��
		map.put("command", new Boutique());
		
		//��ȡѧԺ��Ϣ
		map.put("collegeinfo", collegeInfoService.findAllCollege()) ;
		return "bui/acdemic/boutiqueApply";
	}
	
	/**
	 * ��Ӿ�Ʒ�γ̲���
	 * @param Boutiqueinfo
	 * @return
	 */
	@RequestMapping(value="/addBoutique",method=RequestMethod.POST)
	public String save(String num){
		//���տγ̱�Ż�ȡ�γ�id
		int course_id=courseInfoService.getIdByNum(num);
		//����session�еĽ�ʦid
		int teacher_id=11;
		Boutique Boutiqueinfo = new Boutique();
		Boutiqueinfo.setCourse_id(course_id);
		
		Boutiqueinfo.setTeacher_id(teacher_id);
		
		boutiqueInfoService.insert(Boutiqueinfo);
		return "redirect:/boutique/courselist";
	}
	
	@RequestMapping(value="/updateStatus",method={RequestMethod.POST,RequestMethod.GET})
	public String updateStatus(int id,int status){
		boutiqueInfoService.updateStatusById(id,status);
		return "redirect:/boutique/getAllBoutique";
	}
	
	
	/**
	 * ɾ���û�����
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable(value="id") int id){
		int result = boutiqueInfoService.deleteByPrimaryKey(id);
		System.out.println("ɾ���û��Ĳ������Ϊ��"+result+"���ݽ�����idΪ��"+id);
		return "redirect:/boutique/getAllBoutique";
	}
	/**
	 * ����ǰ�ȸ���id�ҵ��û���Ϣ�����Ե�ҳ����
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/detail/{id}",method=RequestMethod.GET)
	public String input(@PathVariable(value="id") Integer id,Map<String, Object> map){
		map.put("command", boutiqueInfoService.selectByPrimaryKey(id));
		return "addBoutique";
	}
	
	@ModelAttribute
	public void getBoutiqueInfo(@RequestParam(value="BoutiqueId",required=false) Integer id
			,Map<String, Object> map){
		System.out.println("ÿ��controller ���������ȵ�����Ŷ");
		if(id != null){
			System.out.println("update ����");
			map.put("BoutiqueInfo", boutiqueInfoService.selectByPrimaryKey(id));
		}
		System.out.println("insert  ����");
	}
	
	@RequestMapping(value="/addBoutique",method=RequestMethod.PUT)
	public String update(Boutique Boutiqueinfo){
		boutiqueInfoService.updateByPrimaryKey(Boutiqueinfo);
		return "redirect:/boutique/getAllBoutique";
	}
}
