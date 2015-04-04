package com.ds.quiz.dao;

import com.ds.quiz.model.Answer;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by DS on 03.03.2015.
 */
@Repository
public class AnswerDaoImpl extends AbstractDao<Answer, Integer> implements AnswerDao{

    @Override
    public void create(Answer answer) {
        super.create(answer);
    }

    @Override
    public void update(Answer answer) {
        super.update(answer);
    }

    @Override
    public void delete(Answer answer) {
        super.delete(answer);
    }

    @Override
    public List<Answer> findAll() {
        return super.findAll();
    }

    @Override
    public Answer findOne(Integer id) {
        return super.findOne(id);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        super.sessionFactory = sessionFactory;
    }
}
