package com.darparisianstroll.dao;

import java.util.List;

import com.darparisianstroll.domain.Activity;
import com.darparisianstroll.domain.Category;

public interface ActivityDao {

    Activity findById(int activity_id);

    List<Activity> findAllActivities();

    List<Activity> findActivitiesByCategoryId(int category_id);

    List<Activity> findActivitiesByCategory(Category cat);

    List<Activity> findAllVisibleActivities();

    List<Activity> getByName(String name);
}
