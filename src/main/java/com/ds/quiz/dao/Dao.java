package com.ds.quiz.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by DS on 02.03.2015.
 */
public interface Dao<T, PK extends Serializable> {

    public void create(T t);

    public void update(T t);

    public void delete(T t);

    public List<T> findAll();

    public T findOne(PK id);
}
