package com.ds.quiz.service;


import com.ds.quiz.dao.QuestionDao;
import com.ds.quiz.model.Question;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by DS on 03.03.2015.
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionDao questionDao;

    @Transactional
    @Override
    public void addQuestion(Question question) {
        questionDao.create(question);
    }

    @Transactional
    @Override
    public void updateQuestion(Question question) {
        questionDao.update(question);
    }

    @Transactional
    @Override
    public void deleteQuestion(Question question) {
        questionDao.delete(question);
    }

    @Transactional
    @Override
    public Question findQuestion(int id) {
        return questionDao.findOne(id);
    }

    @Transactional
    @Override
    public List<Question> findQuestion() {
        return questionDao.findAll();
    }

    public void setQuestionDao(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }
}
