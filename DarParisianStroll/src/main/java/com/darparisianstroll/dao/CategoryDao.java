package com.darparisianstroll.dao;

import java.util.List;

import com.darparisianstroll.domain.Category;

public interface CategoryDao {

	Category findById(int category_id);

	List<Category> findAllCategories();

	List<Category> findAllVisibleCategories();
}
