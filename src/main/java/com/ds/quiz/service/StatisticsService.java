package com.ds.quiz.service;

import com.ds.quiz.model.Statistics;
import com.ds.quiz.model.User;

import java.util.List;

/**
 * Created by DS on 30.03.2015.
 */
public interface StatisticsService {

    public void addStatistics(Statistics statistics);

    public void updateStatisctics(Statistics statistics);

    public void deleteStatistics(Statistics statistics);

    public Statistics finsStatistics(int id);

    public List<Statistics> findStatistics();

    public List<Statistics> findStatisticsByUser(User user);
}
