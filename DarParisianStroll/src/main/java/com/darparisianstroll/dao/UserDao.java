package com.darparisianstroll.dao;

import java.util.List;

import com.darparisianstroll.domain.User;

public interface UserDao {

    User findById(int user_id);

    void saveUser(User user);

    void deleteUser(int user_id);

    List<User> getByMail(String mail);

    boolean isRegistred(String username, String password);

    List<User> getByUsername(String username);
}
