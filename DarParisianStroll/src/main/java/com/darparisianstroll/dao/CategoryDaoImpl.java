package com.darparisianstroll.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.darparisianstroll.domain.Category;

@Repository("categoryDao")
public class CategoryDaoImpl extends AbstractDao<Integer, Category> implements CategoryDao {

	@Override
	public Category findById(int category_id) {
		return getByKey(category_id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findAllCategories() {
		Criteria criteria = createEntityCriteria();
		return (List<Category>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findAllVisibleCategories() {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.ne("visibility", 0));
		return (List<Category>) criteria.list();
	}

}
