package com.ds.quiz.infrastructure.exam;

import com.ds.quiz.model.Question;

/**
 * Created by DS on 22.03.2015.
 */
public interface Exam {

    public boolean examAnswer(Question question, int answeredId);
}
