package com.ds.quiz.dao;

/**
 * Created by DS on 18.03.2015.
 */
public class EntityDoesNotExistException extends DaoException{
    public EntityDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }
    public EntityDoesNotExistException(String message) {
        super(message);
    }
    public EntityDoesNotExistException(Throwable cause) {
        super(cause);
    }
}
