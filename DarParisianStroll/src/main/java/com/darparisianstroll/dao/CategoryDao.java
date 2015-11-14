package com.darparisianstroll.dao;

import java.util.List;

import com.darparisianstroll.domain.Category;

/**
 * DAO d'une category
 * 
 */
public interface CategoryDao {

    /**
     * retourne une categorie par son id
     * 
     * @param category_id
     *            id de la categorie
     * @return categorie
     */
    Category findById(int category_id);

    /**
     * retourne la liste des categories dans la base
     * 
     * @return liste des categories dans la base
     */
    List<Category> findAllCategories();

    /**
     * retourne la liste des categories visibles dans la base
     * 
     * @return liste des categories visibles dans la base
     */
    List<Category> findAllVisibleCategories();
}
