package com.darparisianstroll.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.darparisianstroll.domain.Route;
import com.darparisianstroll.domain.RouteReview;
import com.darparisianstroll.domain.User;

@Repository("routeReviewDao")
public class RouteReviewDaoImpl extends AbstractDao<Integer, RouteReview>
	implements RouteReviewDao {

    @Override
    public RouteReview findById(int rr_id) {
	return getByKey(rr_id);
    }

    @Override
    public void saveRouteReview(RouteReview rr) {
	persist(rr);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<RouteReview> findRouteReviewsByRoute(Route r) {
	Criteria c = createEntityCriteria();
	c.add(Restrictions.eq("itineraire", r.getRoute_id()));
	return c.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<RouteReview> getByUser(User user) {
	Criteria c = createEntityCriteria();
	c.add(Restrictions.eq("user", user.getUser_id()));
	return c.list();
    }

}
