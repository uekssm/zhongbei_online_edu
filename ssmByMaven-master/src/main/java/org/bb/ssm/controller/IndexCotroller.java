package org.bb.ssm.controller;

import java.util.Map;

import org.bb.ssm.model.User;
import org.bb.ssm.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/index")
public class IndexCotroller {
	
	@Autowired
	private UserInfoService userInfoService;
	
	/**
	 * 展示首页
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/main")
	public String main(){
		return "index";
	}
	
	/**
	 * 展示头部
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/top")
	public String top(){
		return "top";
	}
	
	/**
	 * 展示左部
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/left")
	public String left(){
		return "left";
	}
	
	/**
	 * 展示右部
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/right")
	public String right(){
		return "right";
	}
	
	/**
	 * 展示底部
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/bottom")
	public String bottom(){
		return "bottom";
	}
	
	/**
	 * 登录
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/login")
	public String login(){
		return "login";
	}
	
	/**
	 * 登录用户名和密码校验
	 * @param userinfo
	 * @return
	 */
	@RequestMapping(value="/dologin",method=RequestMethod.POST)
	public String dologin(User userinfo,Map<String, Object> map){
		User result = userInfoService.selectByPwd(userinfo);
		map.put("userinfo", result);
		System.out.println(result);
		return "redirect:main";
	}
	
	/**
	 * 退出
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/loginout")
	public String loginout(){
		return "login";
	}
	
}
