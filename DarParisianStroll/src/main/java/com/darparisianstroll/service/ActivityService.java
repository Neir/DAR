package com.darparisianstroll.service;

import java.util.List;

import com.darparisianstroll.domain.Activity;
import com.darparisianstroll.domain.Category;

public interface ActivityService {

    Activity findById(int activity_id);

    List<Activity> findAllActivities();

    List<Activity> findActivitiesByCategoryId(int category_id);

    List<Activity> findActivitiesByCategory(Category cat);

    List<Activity> findAllVisibleActivities();

    Activity findByName(String name);

}
