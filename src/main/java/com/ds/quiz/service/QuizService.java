package com.ds.quiz.service;

import com.ds.quiz.model.Quiz;

import java.util.List;

/**
 * Created by DS on 03.03.2015.
 */
public interface QuizService {

    public void addQuiz(Quiz quiz);

    public void updateQuiz(Quiz quiz);

    public void deleteQuiz(Quiz quiz);

    public Quiz findQuiz(int id);

    public List<Quiz> findQuizzes();
}
