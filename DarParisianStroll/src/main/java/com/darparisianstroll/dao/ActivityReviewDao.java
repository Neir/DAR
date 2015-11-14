package com.darparisianstroll.dao;

import java.util.List;

import com.darparisianstroll.domain.Activity;
import com.darparisianstroll.domain.ActivityReview;

/**
 * DAO d'une activity_review
 * 
 */
public interface ActivityReviewDao {

    /**
     * retourne une activity_review par son id
     * 
     * @param review_id
     *            id de l'activity_review
     * @return activity_review
     */
    ActivityReview findById(int review_id);

    /**
     * retourne une liste activity_review d'une activite
     * 
     * @param act
     *            activite
     * @return liste activity_review
     */
    List<ActivityReview> findActivityReviewsFromActivity(Activity act);

    /**
     * enregistre un commentaire
     * 
     * @param review
     *            commentaire
     */
    void saveReview(ActivityReview review);
}
