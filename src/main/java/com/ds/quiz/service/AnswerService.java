package com.ds.quiz.service;

import com.ds.quiz.model.Answer;

import java.util.List;

/**
 * Created by DS on 03.03.2015.
 */
public interface AnswerService {

    public void addAnswer(Answer answer);

    public void updateAnswer(Answer answer);

    public void deleteAnswer(Answer answer);

    public Answer findAnswer(int id);

    public List<Answer> findAnswers();
}
