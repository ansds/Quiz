package com.ds.quiz.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by DS on 02.03.2015.
 */
public abstract class AbstractDao<T, PK extends Serializable> implements Dao<T, PK> {

    private Class<T> entityClass;

    @Autowired
    protected SessionFactory sessionFactory;

    @Override
    public void create(T t) {
        sessionFactory.getCurrentSession().save(t);
    }

    @Override
    public void update(T t) {
        sessionFactory.getCurrentSession().update(t);
    }

    @Override
    public void delete(T t) {
        sessionFactory.getCurrentSession().delete(t);
    }

    @Override
    public List<T> findAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("from " + getEntityClass().getName());
        query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<T> list = (List<T>) query.list();
        return list;
    }

    @Override
    public T findOne(PK pk) {
        Query query = (Query) sessionFactory.getCurrentSession().createQuery("from " + getEntityClass().getName() + " where id = :id");
        query.setParameter("id", pk);
        query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<T> list = query.list();
        return (T) list.get(0);
        //return (T) sessionFactory.getCurrentSession().get(getEntityClass(), pk);
    }

    protected Class<T> getEntityClass() {
        if(entityClass == null) {
            entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
        return entityClass;
    }
}
