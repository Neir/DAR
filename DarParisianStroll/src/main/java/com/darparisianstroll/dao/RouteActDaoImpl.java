package com.darparisianstroll.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.darparisianstroll.domain.Activity;
import com.darparisianstroll.domain.Route;
import com.darparisianstroll.domain.RouteAct;

@Repository("routeActDao")
public class RouteActDaoImpl extends AbstractDao<Integer, RouteAct> implements
	RouteActDao {

    @Override
    public RouteAct findById(int ra_id) {
	return getByKey(ra_id);
    }

    @Override
    public void saveRouteAct(RouteAct ra) {
	persist(ra);
    }

    @Override
    public void updateRouteAct(RouteAct ra) {
	update(ra);
    }

    @Override
    public void deleteRouteAct(RouteAct ra) {
	delete(ra);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Activity> findAllActivitiesByRoute(Route r) {
	Criteria c = createEntityCriteria();
	c.add(Restrictions.eq("route", r.getRoute_id()));

	Disjunction d = Restrictions.disjunction();
	for (RouteAct ra : (List<RouteAct>) c.list()) {
	    d.add(Restrictions.eq("id_activity", ra.getActivity()));
	}
	Criteria c2 = getSession().createCriteria(Activity.class);
	c2.add(d);

	return c2.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Route> findAllRoutesByActivities(Activity a) {
	Criteria c = createEntityCriteria();
	c.add(Restrictions.eq("activity", a.getId_activity()));

	Disjunction d = Restrictions.disjunction();
	for (RouteAct ra : (List<RouteAct>) c.list()) {
	    d.add(Restrictions.eq("route_id", ra.getRoute()));
	}
	Criteria c2 = getSession().createCriteria(Route.class);
	c2.add(d);

	return c2.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<RouteAct> getByRoute(Route route) {
	Criteria c = createEntityCriteria();
	c.add(Restrictions.eq("route", route.getRoute_id()));
	return c.list();
    }

}
