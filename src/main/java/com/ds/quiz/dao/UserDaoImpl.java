package com.ds.quiz.dao;

import com.ds.quiz.model.User;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by DS on 27.02.2015.
 */

@Repository
public class UserDaoImpl extends AbstractDao<User, Integer> implements UserDao{

    public void setSessionFactory(SessionFactory sessionFactory) {
        super.sessionFactory = sessionFactory;
    }

    @Override
    public void create(User user) {
        super.create(user);
    }

    @Override
    public void update(User user) {
        super.update(user);
    }

    @Override
    public void delete(User user) {
        super.delete(user);
    }

    @Override
    public List<User> findAll() {
        return super.findAll();
    }

    @Override
    public User findOne(Integer id) {
        return super.findOne(id);
    }

    @Override
    public User findUser(String login) throws EntityDoesNotExistException{
        Session session = sessionFactory.getCurrentSession();
        Query query = (Query) session.createQuery("from User where login = :login")
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        query.setParameter("login", login);
        List<User> userList = query.list();
        if(userList.size() > 0) {
            return userList.get(0);
        } else {
            throw new EntityDoesNotExistException("User with " + login + " does not exist in database");
        }
    }
}
