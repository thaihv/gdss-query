package com.uitgis.ubps.gdssquery.service;

import com.uitgis.ubps.gdssquery.domain.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
}
