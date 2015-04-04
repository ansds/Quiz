package com.ds.quiz.dao;

import com.ds.quiz.model.User;

import java.util.List;

/**
 * Created by DS on 27.02.2015.
 */
public interface UserDao extends Dao<User, Integer>{

    public User findUser(String login) throws EntityDoesNotExistException;
}
