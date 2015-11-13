package com.darparisianstroll.dao;

import java.util.List;

import com.darparisianstroll.domain.Activity;
import com.darparisianstroll.domain.ActivityReview;

public interface ActivityReviewDao {
	
	ActivityReview findById(int review_id);

	List<ActivityReview> findActivityReviewsFromActivity(Activity act);

	void saveReview(ActivityReview review);
}
