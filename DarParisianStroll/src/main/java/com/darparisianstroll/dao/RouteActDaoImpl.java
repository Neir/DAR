package com.darparisianstroll.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.darparisianstroll.domain.Activity;
import com.darparisianstroll.domain.Route;
import com.darparisianstroll.domain.RouteAct;

@Repository("routeActDao")
public class RouteActDaoImpl extends AbstractDao<Integer, RouteAct> implements RouteActDao {

	@Override
	public RouteAct findById(int ra_id) {
		return getByKey(ra_id);
	}

	@Override
	public void saveRouteAct(RouteAct ra) {
		persist(ra);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Activity> findAllActivitiesByRoute(Route r) {
		Criteria c = createEntityCriteria();
		c.add(Restrictions.eq("route", r.getRoute_id()));
		List<RouteAct> routeAct = (List<RouteAct>) c.list();
		Disjunction d = Restrictions.disjunction();
		for (RouteAct ra : routeAct) {
			d.add(Restrictions.eq("id_activity", ra.getActivity()));
		}
		List<Activity> la = new ArrayList<>(0);
		if (routeAct.size() > 0) {
			Criteria c2 = getSession().createCriteria(Activity.class);
			c2.add(d);
			la.addAll((List<Activity>) c2.list());
		}

		return la;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Route> findAllRoutesByActivities(Activity a) {
		Criteria c = createEntityCriteria();
		c.add(Restrictions.eq("activity", a.getId_activity()));
		List<RouteAct> routeAct = (List<RouteAct>) c.list();

		Disjunction d = Restrictions.disjunction();
		for (RouteAct ra : routeAct) {
			d.add(Restrictions.eq("route_id", ra.getRoute()));
		}
		List<Route> lr = new ArrayList<Route>(0);
		if (routeAct.size() > 0) {
			Criteria c2 = getSession().createCriteria(Route.class);
			c2.add(d);
			lr.addAll((List<Route>) c2.list());
		}
		return lr;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RouteAct> findRouteAct(Activity a) {
		Criteria c = createEntityCriteria();
		c.add(Restrictions.eq("activity", a.getId_activity()));
		return (List<RouteAct>) c.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RouteAct> findRouteAct(Route r) {
		Criteria c = createEntityCriteria();
		c.add(Restrictions.eq("route_id", r.getRoute_id()));
		return (List<RouteAct>) c.list();
	}

}
