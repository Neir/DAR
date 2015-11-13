package com.darparisianstroll.dao;

import java.util.List;

import com.darparisianstroll.domain.Activity;
import com.darparisianstroll.domain.Route;
import com.darparisianstroll.domain.RouteAct;

public interface RouteActDao {

    RouteAct findById(int ra_id);

    void saveRouteAct(RouteAct ra);

    List<Activity> findAllActivitiesByRoute(Route r);

    List<Route> findAllRoutesByActivities(Activity a);

    List<RouteAct> getByRoute(Route route);

    void updateRouteAct(RouteAct ra);

    void deleteRouteAct(RouteAct ra);

    List<RouteAct> findRouteAct(Activity a);

}
