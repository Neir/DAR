package com.darparisianstroll.service;

import java.util.List;

import com.darparisianstroll.domain.Activity;
import com.darparisianstroll.domain.Category;

/**
 * Service de la table activity
 *
 */
public interface ActivityService {

    /**
     * Appel a la methode findById du DAO
     * 
     * @param activity_id
     *            id de l'activite
     * @return activite
     */
    Activity findById(int activity_id);

    /**
     * Appel a la methode findAllActivities du DAO
     * 
     * @return liste d'activites
     */
    List<Activity> findAllActivities();

    /**
     * Appel a la methode findActivitiesByCategoryId du DAO
     * 
     * @param category_id
     *            id de la category
     * @return liste d'activites
     */
    List<Activity> findActivitiesByCategoryId(int category_id);

    /**
     * Appel a la methode findActivitiesByCategory du DAO
     * 
     * @param cat
     *            category
     * @return liste d'activites
     */
    List<Activity> findActivitiesByCategory(Category cat);

    /**
     * Appel a la methode findAllVisibleActivities du DAO
     * 
     * @return liste d'activites
     */
    List<Activity> findAllVisibleActivities();

    /**
     * Appel a la methode findByName du DAO
     * 
     * @param name
     *            nome de l'activite
     * @return activite
     */
    Activity findByName(String name);

}
