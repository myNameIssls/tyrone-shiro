package cn.tyrone.shiro.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request){
		
		System.out.println("-------------------------------登录进行时");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		token.setRememberMe(true);
		subject.login(token);
		
		
		return "redirect:/home";
	}
	
	
	@RequestMapping("/home") @RequiresPermissions("user:home")
	public String home(HttpServletRequest request){
		
		System.out.println("****");
		
		
		return "index";
	}
	
}
