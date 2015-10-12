package com.darparisianstroll.dao;

import java.util.List;

import com.darparisianstroll.domain.Route;

public interface RouteDao {

	Route findById(int route_id);

	void saveRoute(Route route);
	
	List<Route> findAllRoutes();

}
