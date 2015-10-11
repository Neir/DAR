package com.darparisianstroll.dao;

import java.util.List;

import com.darparisianstroll.domain.Route;
import com.darparisianstroll.domain.RouteReview;

public interface RouteReviewDao {

	RouteReview findById(int rr_id);

	void saveRouteReview(RouteReview rr);

	List<RouteReview> findRouteReviewsByRoute(Route r);
	
}
