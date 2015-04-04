package com.ds.quiz.controller;

import com.ds.quiz.dao.EntityDoesNotExistException;
import com.ds.quiz.infrastructure.exam.Exam;
import com.ds.quiz.model.*;
import com.ds.quiz.service.QuizService;
import com.ds.quiz.service.StatisticsService;
import com.ds.quiz.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * Created by DS on 18.03.2015.
 */
@Controller
@RequestMapping(value = "/quiz")
@SessionAttributes({"questionCounter", "quiz", "questionQuantity", "question", "result"})
public class QuizController {

    @Resource(name = "quizService")
    private QuizService quizService;
    @Resource(name = "userService")
    private UserService userService;
    @Resource(name = "exam")
    private Exam exam;
    @Resource(name = "statisticsService")
    private StatisticsService statisticsService;

    @RequestMapping(value = "/{quizId}", method = RequestMethod.GET)
    public String showQuiz(@PathVariable int quizId, Model model) {
        model.addAttribute("quiz", quizService.findQuiz(quizId));
        return "quiz";
    }

    @RequestMapping(value = "/{quizId}/start", method = RequestMethod.GET)
    public String startQuiz(@PathVariable int quizId, Model model) {
        int questionCounter = 0;
        Quiz quiz = quizService.findQuiz(quizId);
        Question question = quiz.getQuestions().get(questionCounter);
        model.addAttribute("quiz", quiz);
        model.addAttribute("question", question);
        model.addAttribute("questionCounter", String.valueOf(questionCounter));
        model.addAttribute("questionQuantity", String.valueOf(quiz.getQuestions().size()));
        model.addAttribute("result", 0);
        return "startedquiz";
    }

    @RequestMapping(value = "/{quizId}/start", method = RequestMethod.POST)
    public String nextQuestion(@PathVariable int quizId, Model model,
                               @ModelAttribute(value = "questionCounter") int questionCounter,
                               @ModelAttribute(value = "quiz") Quiz quiz,
                               @ModelAttribute(value = "question") Question previousQuestion,
                               @ModelAttribute(value = "questionQuantity") int questionQuantity,
                               @ModelAttribute(value = "result") int result,
                               @RequestParam(value = "ans", required = false) Integer ans) throws EntityDoesNotExistException {
        if(ans != null) {
            if(exam.examAnswer(previousQuestion, ans)) {
                result++;
            }
        }
        questionCounter ++;
        if(questionCounter == questionQuantity) {

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String username = auth.getName();
            User user = userService.findUser(username);
            Statistics statistics = new Statistics();
            statistics.setUser(user);
            statistics.setQuiz(quiz);
            statistics.setCountRight(result);
            statisticsService.addStatistics(statistics);

            model.addAttribute("quiz", quiz);
            model.addAttribute("result", result);
            return "result";
        }
        Question question = quiz.getQuestions().get(questionCounter);
        model.addAttribute("quiz", quiz);
        model.addAttribute("question", question);
        model.addAttribute("questionCounter", String.valueOf(questionCounter));
        model.addAttribute("result", result);
        return "startedquiz";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getCreatePage() {
        return "createquiz";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createQuiz(HttpServletRequest request) throws EntityDoesNotExistException {
        int questionsCount = Integer.parseInt(request.getParameter("questions"));
        Quiz quiz = new Quiz();
        quiz.setCaption(request.getParameter("quizName"));
        quiz.setDescription(request.getParameter("quizDescription"));
        quiz.setQuestions(new ArrayList<Question>());
        for(int i = 1; i <= questionsCount; i++) {
            Question question = new Question();
            question.setQuestion(request.getParameter("question" + i));
            question.setAnswers(new ArrayList<Answer>());
            quiz.getQuestions().add(question);
            for(int j = 1; j <= 4; j++) {
                Answer answer = new Answer();
                answer.setAnswer(request.getParameter("answer" + i + "." + j));
                if(Integer.valueOf(request.getParameter("question" + i + "radio")) == j) {
                    answer.setCorrect(true);
                }
                question.getAnswers().add(answer);
                answer.setQuestion(question);
            }
            question.setQuiz(quiz);
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User user = userService.findUser(username);
        user.getQuizzes().add(quiz);
        quiz.setUser(user);
        //userService.updateUser(user);
        quizService.addQuiz(quiz);
        return "redirect:/home";
    }

}
