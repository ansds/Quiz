package com.ds.quiz.service;

import com.ds.quiz.dao.EntityDoesNotExistException;
import com.ds.quiz.model.User;

import java.util.List;

/**
 * Created by DS on 01.03.2015.
 */
public interface UserService {

    public void addUser(User user);

    public void updateUser(User user);

    public void deleteUserById(User user);

    public User findUser(int id);

    public User findUser(String login) throws EntityDoesNotExistException;

    public List<User> findUsers();
}
