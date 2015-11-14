package com.darparisianstroll.service;

import java.util.List;

import com.darparisianstroll.domain.Category;

/**
 * Service de la table cetegory
 *
 */
public interface CategoryService {

    /**
     * Appel a la methode findById du DAO
     * 
     * @param category_id
     *            id de la category
     * @return retourne category
     */
    Category findById(int category_id);

    /**
     * Appel a la methode findAllCategories du DAO
     * 
     * @return liste category
     */
    List<Category> findAllCategories();

    /**
     * Appel a la methode findAllVisibleCategories du DAO
     * 
     * @return liste category
     */
    List<Category> findAllVisibleCategories();

}
