package com.darparisianstroll.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.darparisianstroll.domain.Route;
import com.darparisianstroll.domain.User;

@Repository("routeDao")
public class RouteDaoImpl extends AbstractDao<Integer, Route> implements
	RouteDao {

    @Override
    public Route findById(int route_id) {
	return getByKey(route_id);
    }

    @Override
    public void saveRoute(Route route) {
	persist(route);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Route> findAllRoutes() {
	Criteria criteria = createEntityCriteria();
	return criteria.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Route> getByUser(User user) {
	Criteria c = createEntityCriteria();
	c.add(Restrictions.eq("user", user.getUser_id()));
	return c.list();
    }

}
