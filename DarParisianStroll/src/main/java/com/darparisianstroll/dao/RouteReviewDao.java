package com.darparisianstroll.dao;

import java.util.List;

import com.darparisianstroll.domain.Route;
import com.darparisianstroll.domain.RouteReview;
import com.darparisianstroll.domain.User;

public interface RouteReviewDao {

    RouteReview findById(int rr_id);

    void saveRouteReview(RouteReview rr);

    List<RouteReview> findRouteReviewsByRoute(Route r);

    List<RouteReview> getByUser(User user);

}
