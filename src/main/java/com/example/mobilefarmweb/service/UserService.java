package com.example.mobilefarmweb.service;

import com.example.mobilefarmweb.entity.User;

import java.io.IOException;
import java.util.List;

public interface UserService {
	List<User> findAllUsers();

	User save(User user) throws IOException;

	void removeUser(Integer id);

	User findUserByUsername(String username);

	User findUserById(Integer id);
}
