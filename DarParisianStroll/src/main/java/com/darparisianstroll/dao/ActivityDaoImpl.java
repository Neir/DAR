package com.darparisianstroll.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.darparisianstroll.domain.Activity;
import com.darparisianstroll.domain.Category;

@Repository("activityDao")
public class ActivityDaoImpl extends AbstractDao<Integer, Activity> implements ActivityDao {

	@Override
	public Activity findById(int activity_id) {
		return getByKey(activity_id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Activity> findAllActivities() {
		Criteria criteria = createEntityCriteria();
		return (List<Activity>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Activity> findActivitiesByCategoryId(int category_id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("category", category_id));
		return (List<Activity>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Activity> findActivitiesByCategory(Category cat) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("category", cat.getId_category()));
		return (List<Activity>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Activity> findAllVisibleActivities() {
		Criteria criteria = getSession().createCriteria(Category.class);
		criteria.add(Restrictions.ne("visibility", 0));

		List<Category> crList = (List<Category>) criteria.list();
		if(crList.isEmpty()){
			return new ArrayList<Activity>();
		}
		
		Disjunction d = Restrictions.disjunction();
		for (Category cat : crList) {
			d.add(Restrictions.eq("category", cat.getId_category()));
		}

		Criteria c = createEntityCriteria();
		c.add(d);

		return (List<Activity>) c.list();
	}

}
