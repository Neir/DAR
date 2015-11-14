package com.darparisianstroll.dao;

import java.util.List;

import com.darparisianstroll.domain.Route;
import com.darparisianstroll.domain.User;

/**
 * DAO d'une route
 * 
 */
public interface RouteDao {

    /**
     * retourne une route par son id
     * 
     * @param route_id
     *            id de la route
     * @return route
     */
    Route findById(int route_id);

    /**
     * sauvegarde une route
     * 
     * @param route
     *            route
     */
    void saveRoute(Route route);

    /**
     * retourne une liste de routes
     * 
     * @return liste de routes
     */
    List<Route> findAllRoutes();

    /**
     * retourne une liste de routes filtrees par user
     * 
     * @param user
     *            id du user
     * @return liste de routes
     */
    List<Route> getByUser(User user);

    /**
     * met a jout une route
     * 
     * @param route
     *            nouvelle route
     */
    void updateRoute(Route route);

    /**
     * supprime une route
     * 
     * @param route
     *            route
     */
    void deleteRoute(Route route);

}
