package com.example.mobilefarmweb.service.impl;

import com.example.mobilefarmweb.entity.Role;
import com.example.mobilefarmweb.entity.User;
import com.example.mobilefarmweb.service.OrganizationService;
import com.example.mobilefarmweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Random;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserService userService;

	private OrganizationService organizationService;

	public UserDetailsServiceImpl(OrganizationService organizationService){
		this.organizationService=organizationService;
	}
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userService.findUserByUsername(userName);
		if (user == null) {
			throw new UsernameNotFoundException(String.format("Не найден пользователь с именем пользователя: %s", userName));
		}

		List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
//		System.out.println("Пользователь"+ user);
//		Random random = new Random();
//		int number = 100000 + random.nextInt(999999); // number is in the range of 10 to 109
//		System.out.println(number);

		return buildUserForAuthentication(user, authorities);
	}

//	@Transactional
//	public UserDetails loadUserByUsernameAndUnp(String userName, String unp) throws UsernameNotFoundException {
//		User user = userService.findUserByUsername(userName);
//		if (user == null) {
//			throw new UsernameNotFoundException(String.format("Не найден пользователь с именем пользователя: %s", userName));
//		}
//		if(isValidUNP(unp, user.getOrganization().getUnp()))
//		{
//			List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
//			System.out.println(user);
//			return buildUserForAuthentication(user, authorities);
//		}
//		else return null;
//	}

	private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
		Set<GrantedAuthority> roles = new HashSet<>();
		for (Role role : userRoles) {
			roles.add(new SimpleGrantedAuthority(role.getRole()));
		}
		return new ArrayList<>(roles);
	}

	private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
//		System.out.println("authorities"+authorities);
//		System.out.println("Из бд"+user.getOrganization().getUnp());
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
					user.isActive(), true, true, true, authorities);
	}

//	private boolean isValidUNP(String unpL, String unpDB) {
//		// Реализуйте проверку UNP здесь
//		if(unpDB.equals(unpL))
//		{// Возвращайте true, если UNP действителен, иначе false
//		return true;}
//		else {return false;}
//	}


}
