package com.example.mobilefarmweb.controller;

import com.example.mobilefarmweb.entity.User;
import com.example.mobilefarmweb.service.OrganizationService;
import com.example.mobilefarmweb.service.UserService;
import com.example.mobilefarmweb.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;

	private OrganizationService organizationService;
	private UserDetailsServiceImpl userDetailsServiceImpl;

	public LoginController(UserService userService, OrganizationService organizationService, UserDetailsServiceImpl userDetailsServiceImpl){
		this.userService=userService;
		this.organizationService=organizationService;
		this.userDetailsServiceImpl=userDetailsServiceImpl;
	}
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}

	@GetMapping("/")
	public String run() {
		return "login";
	}

//	@PostMapping("/perform_login_unp")
//	public String perform_login(@RequestParam String unp, @RequestParam String username, @RequestParam String password){
//		System.out.println("Мой контроллер");
//		User user = userService.findUserByUsername(username);
//		System.out.println("Введённый"+unp);
//		if(user.getOrganization().getUnp().equals(unp))
//		{
//			userDetailsServiceImpl.loadUserByUsername(username);
//			return "start";
//		}
//		else {
//			throw new UsernameNotFoundException(String.format("UNP не совпадает"));
//		}
//
//	}
}
