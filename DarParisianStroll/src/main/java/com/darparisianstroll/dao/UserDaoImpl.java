package com.darparisianstroll.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.darparisianstroll.domain.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	@Override
	public User findById(int user_id) {
		return getByKey(user_id);
	}

	@Override
	public void saveUser(User user) {
		persist(user);
	}

	@Override
	public void deleteUser(int user_id) {
		Query query = getSession().createSQLQuery("UPDATE users SET state='archive' WHERE user_id = :id");
		query.setInteger("id", user_id);
		query.executeUpdate();
	}

}
