package com.ds.quiz.service;

import com.ds.quiz.model.Question;

import java.util.List;

/**
 * Created by DS on 03.03.2015.
 */
public interface QuestionService {

    public void addQuestion(Question question);

    public void updateQuestion(Question question);

    public void deleteQuestion(Question question);

    public Question findQuestion(int id);

    public List<Question> findQuestion();
}
