package com.ds.quiz.dao;

import com.ds.quiz.model.Question;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by DS on 03.03.2015.
 */
@Repository
public class QuestionDaoImpl extends AbstractDao<Question, Integer> implements QuestionDao {

    @Override
    public void create(Question question) {
        super.create(question);
    }

    @Override
    public void update(Question question) {
        super.update(question);
    }

    @Override
    public void delete(Question question) {
        super.delete(question);
    }

    @Override
    public List<Question> findAll() {
        return super.findAll();
    }

    @Override
    public Question findOne(Integer id) {
        return super.findOne(id);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        super.sessionFactory = sessionFactory;
    }
}
