package com.darparisianstroll.dao;

import java.util.List;

import com.darparisianstroll.domain.Activity;
import com.darparisianstroll.domain.Route;
import com.darparisianstroll.domain.RouteAct;

/**
 * DAO d'une route_act
 * 
 */
public interface RouteActDao {

    /**
     * retourne une route_act par son id
     * 
     * @param ra_id
     *            route_act
     * @return route_act
     */
    RouteAct findById(int ra_id);

    /**
     * sauvegarde une route_act
     * 
     * @param ra
     *            route_act
     */
    void saveRouteAct(RouteAct ra);

    /**
     * retourne une liste d'activitees filtrees par une route
     * 
     * @param r
     *            route
     * @return liste d'activitees
     */
    List<Activity> findAllActivitiesByRoute(Route r);

    /**
     * retourne une liste de routes filtrees par une activite
     * 
     * @param a
     *            activite
     * @return liste de routes
     */
    List<Route> findAllRoutesByActivities(Activity a);

    /**
     * retourne une liste de route_act filtrees par une route
     * 
     * @param route
     *            route
     * @return liste de route_act
     */
    List<RouteAct> getByRoute(Route route);

    /**
     * met a jour une route_act
     * 
     * @param ra
     *            nouvelle route_act
     */
    void updateRouteAct(RouteAct ra);

    /**
     * supprime une route_act
     * 
     * @param ra
     *            route_act
     */
    void deleteRouteAct(RouteAct ra);

    /**
     * retourne une liste de route_act filtrees a partir d'une activite
     * 
     * @param a
     *            activite
     * @return liste de route_act
     */
    List<RouteAct> findRouteAct(Activity a);

}
