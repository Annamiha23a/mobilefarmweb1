package com.example.mobilefarmweb.service.impl;

import com.example.mobilefarmweb.entity.Organization;
import com.example.mobilefarmweb.entity.Role;
import com.example.mobilefarmweb.entity.User;
import com.example.mobilefarmweb.mail.EmailDetails;
import com.example.mobilefarmweb.mail.EmailService;
import com.example.mobilefarmweb.repository.OrganizationRepository;
import com.example.mobilefarmweb.repository.RoleRepository;
import com.example.mobilefarmweb.repository.UserRepository;
import com.example.mobilefarmweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private OrganizationRepository organizationRepository;
	private List<User> list ;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private EmailService emailService;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, OrganizationRepository organizationRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.list = userRepository.findAll();
		this.organizationRepository=organizationRepository;
	}

	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	public User save(User user, String upn)  {
		List<User> users=userRepository.findAll();
		for (User userDB : users) {
			if(user.getUsername().equals(userDB.getUsername())){
				return null;
			}
		}
		EmailDetails details = new EmailDetails(user.getUsername(),"Добро пожаловать в веб ферму. Ваш логин:" + user.getUsername() +". Ваш пароль:"+user.getPassword(), "Регистрация в службе рекрутинга", null);
	    user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(true);
		Role role = list.isEmpty()? roleRepository.findByRole("ROLE_ADMIN") : roleRepository.findByRole("ROLE_USER");
		user.setRoles(new HashSet<>(List.of(role)));
		userRepository.save(user);
		if (user.getUsername()!=null) {
			emailService.sendSimpleMail(details);
		}
		Organization organization=organizationRepository.findByUnp(upn);
		user.setOrganization(organization);
		return userRepository.save(user);
	}

	public User saveRecruter(User user, String firstName, String lastName, String username, String password, String phone, String bio, String age, String s)  {
		EmailDetails details = new EmailDetails(username,"Добро пожаловать на сервис оценки кинофильмов. Ваш логин:" + user.getUsername() +". Ваш пароль:"+user.getPassword(), "Регистрация на сервисе", null);
		user.setPassword(this.bCryptPasswordEncoder.encode(password));
		user.setActive(true);
		Role role =  roleRepository.findByRole("ROLE_RECRUTER");
		user.setRoles(new HashSet<>(List.of(role)));
		userRepository.save(user);
		if (user.getUsername()!=null) {
			emailService.sendSimpleMail(details);
		}

		return userRepository.save(user);
	}

	public void banUser(Integer id) {
		User user = userRepository.findUserById(id).orElse(null);
		if (user!=null){
			if (user.isActive()){
				user.setActive(false);
			} else {
				user.setActive(true);
			}
		}
		userRepository.save(user);
	}

	public void update(Integer id, String firstName, String lastName, String phone, String bio, String age){
		User user = userRepository.findUserById(id).orElse(null);
		if (user!=null){
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setPhone(phone);
			user.setBio(bio);
			user.setAge(age);
		}
		userRepository.save(user);
	}

	@Override
	public void removeUser(Integer id) {
		User user = findUserById(id);
		userRepository.delete(user);
	}

	@Override
	public User findUserByUsername(String username) {
		return userRepository.findUserByUsername(username)
				.orElseThrow(() -> new NoSuchElementException());
	}

	@Override
	public User findUserById(Integer id) {
		return userRepository.findUserById(id)
				.orElseThrow(()->new NoSuchElementException());
	}

	public User getUserByUserName (Principal principal){
		if(principal==null) return new User();
		String username=principal.getName();
		return userRepository.findUserByUsername(username).orElseThrow(()->new NoSuchElementException());
	}
	public Integer sendCod(String username){
		Random random = new Random();
		Integer number = 100000 + random.nextInt(999999); // number is in the range of 10 to 109
		System.out.println(number);
		EmailDetails details = new EmailDetails(username,number.toString(), "Регистрация", null);
		if (username!=null) {
			emailService.sendSimpleMail(details);
		}
		return number;
	}

}
