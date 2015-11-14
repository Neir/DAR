package com.darparisianstroll.dao;

import java.util.List;

import com.darparisianstroll.domain.Activity;
import com.darparisianstroll.domain.Category;

/**
 * DAO d'une activity
 * 
 */
public interface ActivityDao {

    /**
     * retourne une activite par son id
     * 
     * @param activity_id
     *            id de l'activite
     * @return activite
     */
    Activity findById(int activity_id);

    /**
     * retourne liste des activites
     * 
     * @return liste des activites
     */
    List<Activity> findAllActivities();

    /**
     * retourne la liste des activites filtres par categorie
     * 
     * @param category_id
     *            id de la categorie
     * @return liste des activites filtres par categorie
     */
    List<Activity> findActivitiesByCategoryId(int category_id);

    /**
     * retourne la liste des activites filtres par categorie
     * 
     * @param cat
     *            categorie
     * @return liste des activites filtres par categorie
     */
    List<Activity> findActivitiesByCategory(Category cat);

    /**
     * retourne la liste des activites visibles
     * 
     * @return activites visibles
     */
    List<Activity> findAllVisibleActivities();

    /**
     * retourne la liste des activites filtres par nom
     * 
     * @param name
     *            nom de l'activite
     * @return activite
     */
    List<Activity> getByName(String name);
}
