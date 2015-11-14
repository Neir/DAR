package com.darparisianstroll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.darparisianstroll.dao.ActivityReviewDao;
import com.darparisianstroll.domain.Activity;
import com.darparisianstroll.domain.ActivityReview;

@Service("activityReviewService")
@Transactional
public class ActivityReviewServiceImpl implements ActivityReviewService {

    @Autowired
    private ActivityReviewDao dao;

    @Override
    public ActivityReview findById(int review_id) {
	return dao.findById(review_id);
    }

    @Override
    public List<ActivityReview> findActivityReviewsFromActivity(Activity act) {
	return dao.findActivityReviewsFromActivity(act);
    }

    @Override
    public void saveReview(ActivityReview review) {
	dao.saveReview(review);

    }

}
