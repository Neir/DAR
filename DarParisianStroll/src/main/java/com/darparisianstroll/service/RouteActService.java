package com.darparisianstroll.service;

import java.util.List;

import com.darparisianstroll.domain.Activity;
import com.darparisianstroll.domain.Route;
import com.darparisianstroll.domain.RouteAct;

/**
 * Service de la table route_act
 *
 */
public interface RouteActService {

    /**
     * Appel a la methode findById du DAO
     * 
     * @param ra_id
     *            id de route_act
     * @return route_act
     */
    RouteAct findById(int ra_id);

    /**
     * Appel a la methode findById du DAO
     * 
     * @param ra
     *            route_act
     */
    void saveRouteAct(RouteAct ra);

    /**
     * Appel a la methode findById du DAO
     * 
     * @param r
     *            route
     * @return liste d'activites
     */
    List<Activity> findAllActivitiesByRoute(Route r);

    /**
     * Appel a la methode findById du DAO
     * 
     * @param a
     *            activite
     * @return liste de routes
     */
    List<Route> findAllRoutesByActivities(Activity a);

    /**
     * Appel a la methode findById du DAO
     * 
     * @param route
     *            route
     * @return liste de route_act
     */
    List<RouteAct> getByRoute(Route route);

    /**
     * Appel a la methode findById du DAO
     * 
     * @param ra
     *            route_act
     */
    void updateRouteAct(RouteAct ra);

    /**
     * Appel a la methode findById du DAO
     * 
     * @param ra
     *            route_act
     */
    void deleteRouteAct(RouteAct ra);

    /**
     * Appel a la methode findById du DAO
     * 
     * @param a
     *            activite
     * @return route_act
     */
    List<RouteAct> findRouteAct(Activity a);

}
