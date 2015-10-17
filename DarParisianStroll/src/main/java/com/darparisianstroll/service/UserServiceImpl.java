package com.darparisianstroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.darparisianstroll.dao.UserDao;
import com.darparisianstroll.domain.User;
import com.darparisianstroll.domain.enums.State;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Override
    public User findById(int user_id) {
	return dao.findById(user_id);
    }

    @Override
    public void saveUser(User user) {
	dao.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
	User entity = dao.findById(user.getUser_id());
	if (entity != null) {
	    entity.setMail(user.getMail());
	    entity.setPassword(user.getPassword());
	    entity.setState(user.getState());
	    entity.setUsername(user.getUsername());
	}

    }

    @Override
    public void deleteUser(int user_id) {
	User entity = dao.findById(user_id);
	if (entity != null) {
	    entity.setState(State.archive);
	}

    }

    @Override
    public User findByEmail(String mail) {
	return dao.getByMail(mail).get(0);
    }

    @Override
    public User findByUsername(String username) {
	return dao.getByUsername(username).get(0);
    }

    @Override
    public boolean isRegistred(String mail) {
	return !dao.getByMail(mail).isEmpty();
    }

    @Override
    public boolean isRegistred(String username, String password) {
	return dao.isRegistred(username, password);
    }
}
