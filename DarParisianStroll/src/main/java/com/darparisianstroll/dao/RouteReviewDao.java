package com.darparisianstroll.dao;

import java.util.List;

import com.darparisianstroll.domain.Route;
import com.darparisianstroll.domain.RouteReview;
import com.darparisianstroll.domain.User;

/**
 * DAO d'une route_review
 * 
 */
public interface RouteReviewDao {

    /**
     * retourne une route_review par son id
     * 
     * @param rr_id
     *            id de la route_review
     * @return route_review
     */
    RouteReview findById(int rr_id);

    /**
     * sauvegarde une route_review dans la base
     * 
     * @param rr
     *            route_review
     */
    void saveRouteReview(RouteReview rr);

    /**
     * retourne une liste de route_review trouves a partir d'une route
     * 
     * @param r
     *            route
     * @return liste de route_review
     */
    List<RouteReview> findRouteReviewsByRoute(Route r);

    /**
     * retourne le user ayant cree le commentaire
     * 
     * @param user
     *            user
     * @return route_review
     */
    List<RouteReview> getByUser(User user);

}
