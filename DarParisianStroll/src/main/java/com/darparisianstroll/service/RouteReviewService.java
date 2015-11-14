package com.darparisianstroll.service;

import java.util.List;

import com.darparisianstroll.domain.Route;
import com.darparisianstroll.domain.RouteReview;
import com.darparisianstroll.domain.User;

/**
 * Service de la table route_review
 *
 */
public interface RouteReviewService {

    /**
     * Appel a la methode findById du DAO
     * 
     * @param rr_id
     *            id de la route_review
     * @return route_review
     */
    RouteReview findById(int rr_id);

    /**
     * Appel a la methode findById du DAO
     * 
     * @param rr
     *            route_review
     */
    void saveRouteReview(RouteReview rr);

    /**
     * Appel a la methode findById du DAO
     * 
     * @param r
     *            route
     * @return liste de route_review
     */
    List<RouteReview> findRouteReviewsByRoute(Route r);

    /**
     * Appel a la methode findById du DAO
     * 
     * @param user
     *            user
     * @return liste de route_review
     */
    List<RouteReview> getByUser(User user);

}
