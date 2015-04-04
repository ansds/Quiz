package com.ds.quiz.dao;

import com.ds.quiz.model.Statistics;
import com.ds.quiz.model.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by DS on 30.03.2015.
 */
public class StatisticsDaoImpl extends AbstractDao<Statistics, Integer> implements StatisticsDao {

    @Override
    public void create(Statistics statistics) {
        super.create(statistics);
    }

    @Override
    public void update(Statistics statistics) {
        super.update(statistics);
    }

    @Override
    public void delete(Statistics statistics) {
        super.delete(statistics);
    }

    @Override
    public List<Statistics> findAll() {
        return super.findAll();
    }

    @Override
    public Statistics findOne(Integer id) {
        return super.findOne(id);
    }

    @Override
    public List<Statistics> getStatisticsByUser(User user) {
        int userId = user.getId();
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from Statistics statistics WHERE statistics.user.id = :userId")
                .setInteger("userId", userId)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Statistics> userStatistics = (List<Statistics>) query.list();
        return userStatistics;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        super.sessionFactory = sessionFactory;
    }
}
