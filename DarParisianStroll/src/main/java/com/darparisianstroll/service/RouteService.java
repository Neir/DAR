package com.darparisianstroll.service;

import java.util.List;

import com.darparisianstroll.domain.Route;
import com.darparisianstroll.domain.User;

public interface RouteService {

    Route findById(int route_id);

    void saveRoute(Route route);

    List<Route> findAllRoutes();

    List<Route> getByUser(User user);

    void updateRoute(Route route);

    void deleteRoute(Route route);

}
