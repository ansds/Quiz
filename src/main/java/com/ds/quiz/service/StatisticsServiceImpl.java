package com.ds.quiz.service;

import com.ds.quiz.dao.StatisticsDao;
import com.ds.quiz.model.Statistics;
import com.ds.quiz.model.User;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by DS on 30.03.2015.
 */
public class StatisticsServiceImpl implements StatisticsService {

    private StatisticsDao statiscticsDao;

    @Transactional
    @Override
    public void addStatistics(Statistics statistics) {
        statiscticsDao.create(statistics);
    }

    @Transactional
    @Override
    public void updateStatisctics(Statistics statistics) {
        statiscticsDao.update(statistics);
    }

    @Transactional
    @Override
    public void deleteStatistics(Statistics statistics) {
        statiscticsDao.delete(statistics);
    }

    @Transactional
    @Override
    public Statistics finsStatistics(int id) {
        return statiscticsDao.findOne(id);
    }

    @Transactional
    @Override
    public List<Statistics> findStatistics() {
        return statiscticsDao.findAll();
    }

    @Transactional
    @Override
    public List<Statistics> findStatisticsByUser(User user) {
        return statiscticsDao.getStatisticsByUser(user);
    }

    public void setStatiscticsDao(StatisticsDao statiscticsDao) {
        this.statiscticsDao = statiscticsDao;
    }
}
