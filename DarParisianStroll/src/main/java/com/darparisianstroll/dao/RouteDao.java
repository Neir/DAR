package com.darparisianstroll.dao;

import java.util.List;

import com.darparisianstroll.domain.Route;
import com.darparisianstroll.domain.User;

public interface RouteDao {

    Route findById(int route_id);

    void saveRoute(Route route);

    List<Route> findAllRoutes();

    List<Route> getByUser(User user);

}
