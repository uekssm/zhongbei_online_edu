package org.bb.ssm.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.bb.ssm.model.Boutique;
import org.bb.ssm.model.User;
import org.bb.ssm.service.BoutiqueInfoService;
import org.bb.ssm.service.MenuInfoService;
import org.bb.ssm.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/login")
public class LoginCotroller {
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private BoutiqueInfoService boutiqueInfoService;
	/**
	 * չʾ��ҳ
	 * 
	 * @return
	 */
	@RequestMapping(value="/main")
	public String main(Map<String, Object> map) {
		List<Boutique> BoutiqueList = boutiqueInfoService.findCourse();//�����Ƽ�|��Ʒ�γ�
		map.put("ALLMENU", BoutiqueList);
		return "stage/login/index";
	}
	
	
	
	/**
	 * �򿪵�¼����
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/login")
	public String login(){
		return "stage/login/login1";
	}
	
	/**
	 * ��¼�û���������У��
	 * @param userinfo
	 * @return
	 */
	@RequestMapping(value="/dologin",method=RequestMethod.POST)
	public String dologin(User userinfo , HttpSession httpSession){
		
		User result = userInfoService.selectByPwd(userinfo);
		
		if(result == null)
		{
			return "redirect:login";//Ӧ����ת�� ���ݳ�����Ϣ
		}
		
		httpSession.setAttribute("userinfo", result);
		
		return "redirect:main";
	}
	
	/**
	 * �˳�
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/loginout")
	public String loginout(HttpSession httpSession){
		
		httpSession.invalidate();
		
		return "redirect:login";
	}
	
}
