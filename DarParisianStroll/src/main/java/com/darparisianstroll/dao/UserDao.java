package com.darparisianstroll.dao;

import com.darparisianstroll.domain.User;

public interface UserDao {

	User findById(int user_id);

	void saveUser(User user);

	void deleteUser(int user_id);
}
