package com.darparisianstroll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.darparisianstroll.dao.RouteActDao;
import com.darparisianstroll.domain.Activity;
import com.darparisianstroll.domain.Route;
import com.darparisianstroll.domain.RouteAct;

@Service("routeActService")
@Transactional
public class RouteActServiceImpl implements RouteActService {

    @Autowired
    private RouteActDao dao;

    @Override
    public RouteAct findById(int ra_id) {
	return dao.findById(ra_id);
    }

    @Override
    public List<Activity> findAllActivitiesByRoute(Route r) {
	return dao.findAllActivitiesByRoute(r);
    }

    @Override
    public List<Route> findAllRoutesByActivities(Activity a) {
	return dao.findAllRoutesByActivities(a);
    }

    @Override
    public void saveRouteAct(RouteAct ra) {
	dao.saveRouteAct(ra);

    }

    @Override
    public List<RouteAct> getByUser(Route route) {
	return dao.getByRoute(route);
    }

}
