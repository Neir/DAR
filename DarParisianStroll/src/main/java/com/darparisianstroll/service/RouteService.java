package com.darparisianstroll.service;

import java.util.List;

import com.darparisianstroll.domain.Route;

public interface RouteService {

	Route findById(int route_id);

	void saveRoute(Route route);

	List<Route> findAllRoutes();

}
