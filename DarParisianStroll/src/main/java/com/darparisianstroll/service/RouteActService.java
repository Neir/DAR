package com.darparisianstroll.service;

import java.util.List;

import com.darparisianstroll.domain.Activity;
import com.darparisianstroll.domain.Route;
import com.darparisianstroll.domain.RouteAct;

public interface RouteActService {

	RouteAct findById(int ra_id);
	
	void saveRouteAct(RouteAct ra);

	List<Activity> findAllActivitiesByRoute(Route r);

	List<Route> findAllRoutesByActivities(Activity a);

}
