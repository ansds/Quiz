package com.ds.quiz.controller;

import com.ds.quiz.model.Quiz;
import com.ds.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by DS on 05.03.2015.
 */

@Controller
public class HomeController {

    @Resource(name = "quizService")
    private QuizService quizService;

    @RequestMapping({"/", "/home"})
    public String showHomePage(Map<String, Object> model) {
        model.put("quizzes", quizService.findQuizzes());

        return "home";
    }

//    public void setQuizService(QuizService quizService) {
//        this.quizService = quizService;
//    }
}
