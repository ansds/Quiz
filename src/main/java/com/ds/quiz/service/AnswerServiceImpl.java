package com.ds.quiz.service;

import com.ds.quiz.dao.AnswerDao;
import com.ds.quiz.model.Answer;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by DS on 03.03.2015.
 */
@Service
public class AnswerServiceImpl implements AnswerService {

    private AnswerDao answerDao;

    @Transactional
    @Override
    public void addAnswer(Answer answer) {
        answerDao.create(answer);
    }

    @Transactional
    @Override
    public void updateAnswer(Answer answer) {
        answerDao.update(answer);
    }

    @Transactional
    @Override
    public void deleteAnswer(Answer answer) {
        answerDao.delete(answer);
    }

    @Transactional
    @Override
    public Answer findAnswer(int id) {
        return answerDao.findOne(id);
    }

    @Transactional
    @Override
    public List<Answer> findAnswers() {
        return answerDao.findAll();
    }

    public void setAnswerDao(AnswerDao answerDao) {
        this.answerDao = answerDao;
    }
}
