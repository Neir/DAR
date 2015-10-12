package com.darparisianstroll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.darparisianstroll.dao.RouteDao;
import com.darparisianstroll.domain.Route;

@Service("routeService")
@Transactional
public class RouteServiceImpl implements RouteService {

	@Autowired
	private RouteDao dao;

	@Override
	public Route findById(int route_id) {
		return dao.findById(route_id);
	}

	@Override
	public void saveRoute(Route route) {
		dao.saveRoute(route);
	}

	@Override
	public List<Route> findAllRoutes() {
		return dao.findAllRoutes();
	}

}
