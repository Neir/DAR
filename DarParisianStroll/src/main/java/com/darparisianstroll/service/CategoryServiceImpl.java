package com.darparisianstroll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.darparisianstroll.dao.CategoryDao;
import com.darparisianstroll.domain.Category;

@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryDao dao;

	@Override
	public Category findById(int category_id) {
		return dao.findById(category_id);
	}

	@Override
	public List<Category> findAllCategories() {
		return dao.findAllCategories();
	}

	@Override
	public List<Category> findAllVisibleCategories() {
		return dao.findAllVisibleCategories();
	}

}
