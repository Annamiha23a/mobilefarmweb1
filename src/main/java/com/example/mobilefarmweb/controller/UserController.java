package com.example.mobilefarmweb.controller;

import com.example.mobilefarmweb.entity.Role;
import com.example.mobilefarmweb.entity.User;
import com.example.mobilefarmweb.service.impl.RoleServiceImpl;
import com.example.mobilefarmweb.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class UserController {
	private final UserServiceImpl userService;
	private final RoleServiceImpl roleService;

	@Autowired
	public UserController(UserServiceImpl userService, RoleServiceImpl roleService) {
		this.userService = userService;
		this.roleService = roleService;
	}

	@GetMapping("/users")
	public String findAllUsers(Model model) {
		List<User> users = userService.findAllUsers();
		users.forEach(System.out::println);
		model.addAttribute("users", users);
		return "users";
	}

	@GetMapping("/user/{id}")
	public String findUser(@PathVariable(value = "id") int id, Model model) {
		User user = userService.findUserById(id);
		List<User> users = new ArrayList<>();
		users.add(user);
		model.addAttribute("user", users);
		return "user-details";
	}

	@GetMapping("/office")
	public String userOffice(Principal principal, Model model){
		User user= userService.findUserByUsername(principal.getName());
		List<Role> roles = new ArrayList<>();
		for (Role role : user.getRoles()) {
			// Действия с каждым элементом role
			System.out.println(role.getRole());
			roles.add(role);
		}
		//Role role = roleService.findRoleById(user.getRoles());
		System.out.println("user.getRoles()"+ user.getRoles());
		System.out.println("principal"+principal);
		model.addAttribute("user", user);
		model.addAttribute("roles", roles);
		return "userOffice";
	}

	@PostMapping("/user/{id}/remove")
	public String removeUser(@PathVariable(value = "id") int id, Model model) {
		userService.removeUser(id);
		return "users";
	}

	@PostMapping("user/{id}/ban")
	public String banUser(@PathVariable(value = "id")int id, Model model){
		userService.banUser(id);
		return"redirect:/users";
	}
	@GetMapping("/user/{id}/update")
	public String updateUser(@PathVariable(value = "id") int id, Model model) {
		User user = userService.findUserById(id);
		List<User> users = new ArrayList<>();
		users.add(user);
		model.addAttribute("user",users);
		return "updateUser";
	}
	@PostMapping("/user/{id}/updateU")
	public String updateU(@PathVariable(value = "id") int id, @RequestParam(value="firstName")String firstName,
						  @RequestParam(value="lastName")String lastName, @RequestParam(value="phone")String phone,
						  @RequestParam(value="bio")String bio,@RequestParam(value="age")String age, Model model) {
		userService.update(id,firstName,lastName,phone,bio,age);
		//List<User> users = new ArrayList<>();
		//users.add(user);
		//model.addAttribute("user",users);
		return "redirect:/users";
	}
}
