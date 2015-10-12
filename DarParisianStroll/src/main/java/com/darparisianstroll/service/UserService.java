package com.darparisianstroll.service;

import com.darparisianstroll.domain.User;

public interface UserService {

	User findById(int user_id);

	void saveUser(User user);

	void updateUser(User user);

	void deleteUser(int user_id);

}
