package com.ds.quiz.dao;

import com.ds.quiz.model.Quiz;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by DS on 03.03.2015.
 */
@Repository
public class QuizDaoImpl extends AbstractDao<Quiz, Integer> implements QuizDao{

    @Override
    public void create(Quiz quiz) {
        super.create(quiz);
    }

    @Override
    public void update(Quiz quiz) {
        super.update(quiz);
    }

    @Override
    public void delete(Quiz quiz) {
        super.delete(quiz);
    }

    @Override
    public List<Quiz> findAll() {
        return super.findAll();
    }

    @Override
    public Quiz findOne(Integer id) {
        return super.findOne(id);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        super.sessionFactory = sessionFactory;
    }
}
