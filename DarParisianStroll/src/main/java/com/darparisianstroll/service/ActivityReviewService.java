package com.darparisianstroll.service;

import java.util.List;

import com.darparisianstroll.domain.Activity;
import com.darparisianstroll.domain.ActivityReview;

/**
 * Service de la table activity_review
 *
 */
public interface ActivityReviewService {

    /**
     * Appel a la methode findById du DAO
     * 
     * @param review_id
     *            id de l'activity_review
     * @return commentaire
     */
    ActivityReview findById(int review_id);

    /**
     * Appel a la methode findActivityReviewsFromActivity du DAO
     * 
     * @param act
     *            id de l'activite
     * @return liste activity_review
     */
    List<ActivityReview> findActivityReviewsFromActivity(Activity act);

    /**
     * Appel a la methode saveReview du DAO
     * 
     * @param review
     *            activity_review
     */
    void saveReview(ActivityReview review);

}
