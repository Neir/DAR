package com.darparisianstroll.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.darparisianstroll.domain.Activity;
import com.darparisianstroll.domain.ActivityReview;

@Repository("activityReviewDao")
public class ActivityReviewDaoImpl extends AbstractDao<Integer, ActivityReview> implements ActivityReviewDao {

	@Override
	public ActivityReview findById(int review_id) {
		return getByKey(review_id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ActivityReview> findActivityReviewsFromActivity(Activity act) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("activity", act.getId_activity()));
		return (List<ActivityReview>) criteria.list();
	}

	@Override
	public void saveReview(ActivityReview review) {
		persist(review);
	}

}
