package com.darparisianstroll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.darparisianstroll.dao.RouteReviewDao;
import com.darparisianstroll.domain.Route;
import com.darparisianstroll.domain.RouteReview;

@Service("routeReviewService")
@Transactional
public class RouteReviewServiceImpl implements RouteReviewService {

	@Autowired
	private RouteReviewDao dao;
	
	
	@Override
	public RouteReview findById(int rr_id) {
		return dao.findById(rr_id);
	}

	@Override
	public void saveRouteReview(RouteReview rr) {
		dao.saveRouteReview(rr);

	}

	@Override
	public List<RouteReview> findRouteReviewsByRoute(Route r) {
		return dao.findRouteReviewsByRoute(r);
	}

}
