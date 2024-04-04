package com.example.mobilefarmweb.controller;

import com.example.mobilefarmweb.entity.User;
import com.example.mobilefarmweb.service.UserService;
import com.example.mobilefarmweb.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.security.Principal;

@Controller
public class RegistrationController {
	private UserService userService;
	private UserServiceImpl userServiceImpl;

	@Autowired
	public RegistrationController(UserService userService, UserServiceImpl userServiceImpl) {
		this.userService = userService;
		this.userServiceImpl=userServiceImpl;
	}

	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute(new User());
		return "registration";
	}

	@GetMapping("/start")
	public String start(Principal principal, Model model){
		User user=userServiceImpl.getUserByUserName(principal);
		model.addAttribute("user", user);
		return "start";
	}

	@PostMapping("/registration")
	public String addUser(@ModelAttribute User user, RedirectAttributes redirectAttributes, Model model, @RequestParam String upn) throws IOException {
		User user1=userService.save(user, upn);
		if(user1==null){
			return "redirect:/registration";
		}
		Integer cod=userService.sendCod(user.getUsername());
		System.out.println(cod);
		model.addAttribute("cod", cod);
		return "check";
	}

	@GetMapping("/send")
	public String sendCod(@PathVariable String username, Model model)  {
		Integer cod=userService.sendCod(username);
		model.addAttribute("cod", cod);
		return "redirect:/registration";
	}
}
