package com.darparisianstroll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.darparisianstroll.dao.ActivityDao;
import com.darparisianstroll.domain.Activity;
import com.darparisianstroll.domain.Category;

@Service("activityService")
@Transactional
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private ActivityDao dao;

	@Override
	public Activity findById(int activity_id) {
		return dao.findById(activity_id);
	}

	@Override
	public List<Activity> findAllActivities() {
		return dao.findAllActivities();
	}

	@Override
	public List<Activity> findActivitiesByCategoryId(int category_id) {
		return dao.findActivitiesByCategoryId(category_id);
	}

	@Override
	public List<Activity> findAllVisibleActivities() {
		return dao.findAllVisibleActivities();
	}

	@Override
	public List<Activity> findActivitiesByCategory(Category cat) {
		return dao.findActivitiesByCategory(cat);
	}

}
