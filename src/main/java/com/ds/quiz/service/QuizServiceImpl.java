package com.ds.quiz.service;

import com.ds.quiz.dao.QuizDao;
import com.ds.quiz.model.Quiz;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by DS on 03.03.2015.
 */
@Service
public class QuizServiceImpl implements QuizService {

    private QuizDao quizDao;

    @Transactional
    @Override
    public void addQuiz(Quiz quiz) {
        quizDao.create(quiz);
    }

    @Transactional
    @Override
    public void updateQuiz(Quiz quiz) {
        quizDao.update(quiz);
    }

    @Transactional
    @Override
    public void deleteQuiz(Quiz quiz) {
        quizDao.delete(quiz);
    }

    @Transactional
    @Override
    public Quiz findQuiz(int id) {
        return quizDao.findOne(id);
    }

    @Transactional
    @Override
    public List<Quiz> findQuizzes() {
        return quizDao.findAll();
    }

    public void setQuizDao(QuizDao quizDao) {
        this.quizDao = quizDao;
    }
}
