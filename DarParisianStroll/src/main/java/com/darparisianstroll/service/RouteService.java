package com.darparisianstroll.service;

import java.util.List;

import com.darparisianstroll.domain.Route;
import com.darparisianstroll.domain.User;

/**
 * Service de la table route
 *
 */
public interface RouteService {

    /**
     * Appel a la methode findById du DAO
     * 
     * @param route_id
     *            id de la route
     * @return route
     */
    Route findById(int route_id);

    /**
     * Appel a la methode findById du DAO
     * 
     * @param route
     *            route
     */
    void saveRoute(Route route);

    /**
     * Appel a la methode findById du DAO
     * 
     * @return liste de routes
     */
    List<Route> findAllRoutes();

    /**
     * Appel a la methode findById du DAO
     * 
     * @param user
     *            user
     * @return liste de routes
     */
    List<Route> getByUser(User user);

    /**
     * Appel a la methode findById du DAO
     * 
     * @param route
     *            route
     */
    void updateRoute(Route route);

    /**
     * Appel a la methode findById du DAO
     * 
     * @param route
     *            route
     */
    void deleteRoute(Route route);

}
