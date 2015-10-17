package com.darparisianstroll.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.darparisianstroll.domain.User;
import com.darparisianstroll.domain.enums.State;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

    @Autowired
    SessionFactory sessionFactory;

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
	Query query = getSession().createSQLQuery(
		"UPDATE users SET state='archive' WHERE user_id = :id");
	query.setInteger("id", user_id);
	query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getByMail(String mail) {
	Criteria c = createEntityCriteria();
	c.add(Restrictions.eq("mail", mail));
	return c.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getByUsername(String username) {
	Criteria c = createEntityCriteria();
	c.add(Restrictions.eq("username", username));
	return c.list();
    }

    @Override
    public boolean isRegistred(String username, String password) {
	Criteria c = createEntityCriteria();
	c.add(Restrictions.eq("username", username));
	c.add(Restrictions.eq("password", password));
	c.add(Restrictions.eq("state", State.membre));
	return !c.list().isEmpty();
    }

}
