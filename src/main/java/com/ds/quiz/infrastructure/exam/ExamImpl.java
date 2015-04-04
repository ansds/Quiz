package com.ds.quiz.infrastructure.exam;

import com.ds.quiz.model.Answer;
import com.ds.quiz.model.Question;

import java.util.List;

/**
 * Created by DS on 22.03.2015.
 */
public class ExamImpl implements Exam{

    @Override
    public boolean examAnswer(Question question, int answeredId) {
        List<Answer> answers = question.getAnswers();
        for(Answer answer: answers) {
            if(answer.getId() == answeredId) {
                return answer.isCorrect();
            }
        }
        return false;
    }
}
