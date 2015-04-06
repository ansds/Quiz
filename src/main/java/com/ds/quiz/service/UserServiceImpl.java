package com.ds.quiz.service;

import com.ds.quiz.dao.EntityDoesNotExistException;
import com.ds.quiz.dao.UserDao;
import com.ds.quiz.infrastructure.crypt.CryptUtils;
import com.ds.quiz.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by DS on 01.03.2015.
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void addUser(User user) {
        user.setSalt(CryptUtils.generateSalt());
        user.setCryptedPassword(CryptUtils.cryptPassword(user.getPassword(), user.getSalt()));
        userDao.create(user);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userDao.update(user);
    }

    @Transactional
    @Override
    public void deleteUserById(User user) {
        userDao.delete(user);
    }

    @Transactional
    @Override
    public User findUser(int id) {
        return userDao.findOne(id);
    }

    @Transactional
    @Override
    public User findUser(String username) throws EntityDoesNotExistException {
        return userDao.findUser(username);
    }

    @Transactional
    @Override
    public List<User> findUsers() {
        return userDao.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            return userDao.findUser(username);
        } catch (EntityDoesNotExistException e) {
            throw new UsernameNotFoundException("User cannot was not found in database", e);
        }
    }
}
