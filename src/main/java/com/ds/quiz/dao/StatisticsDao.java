package com.ds.quiz.dao;

import com.ds.quiz.model.Statistics;
import com.ds.quiz.model.User;

import java.util.List;

/**
 * Created by DS on 30.03.2015.
 */
public interface StatisticsDao extends Dao<Statistics, Integer> {

    public List<Statistics> getStatisticsByUser(User user);
}
