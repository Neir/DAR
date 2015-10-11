package com.darparisianstroll.service;

import java.util.List;

import com.darparisianstroll.domain.Category;

public interface CategoryService {

	Category findById(int category_id);

	List<Category> findAllCategories();

	List<Category> findAllVisibleCategories();

}
