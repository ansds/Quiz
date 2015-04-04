package com.ds.quiz.dao;

/**
 * Created by DS on 18.03.2015.
 */
public class DaoException extends Exception {
    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }
    public DaoException(String message) {
        super(message);
    }
    public DaoException(Throwable cause) {
        super(cause);
    }
}
