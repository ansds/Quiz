package com.ds.quiz.controller;

import com.ds.quiz.model.*;
import com.ds.quiz.service.QuestionService;
import com.ds.quiz.service.QuizService;
import com.ds.quiz.service.StatisticsService;
import com.ds.quiz.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import static java.util.Arrays.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.List;

/**
 * Created by DS on 05.03.2015.
 */
public class HomeControllerTest {


//    @Test
//    public void shouldDisplayQuizzes() {
//        List<Quiz> expectedQuizzes = asList(new Quiz(), new Quiz(), new Quiz());
//
//        QuizService quizService = mock(QuizService.class);
//
//        when(quizService.findQuizzes()).thenReturn(expectedQuizzes);
//
//        HomeController controller = new HomeController();
//        //controller.setQuizService(quizService);
//
//        HashMap<String, Object> model = new HashMap<String, Object>();
//
//        String viewName = controller.showHomePage(model);
//
//        assertEquals("home", viewName);
//
//        assertSame(expectedQuizzes, model.get("quizzes"));
//        verify(quizService).findQuizzes();
//    }

//    @Test
//    public void test() {
//        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("C:\\Users\\DS\\Downloads\\eshop-master\\Quiz\\src\\test\\webapp\\WEB-INF\\spring\\appContext.xml");
//        StatisticsService statisticsService = (StatisticsService) applicationContext.getBean("statisticsService");
//
//        User user = new User();
//        user.setId(1);
//
//        List<Statistics> statisticsList = statisticsService.findStatisticsByUser(user);
//        System.out.println(statisticsList.get(0).getCountRight());


//        quizService = (QuizService) applicationContext.getBean("quizService");
//        Quiz quiz = quizService.findQuiz(1);
//        //System.out.println(quiz);
//        UserService userService = (UserService) applicationContext.getBean("userService");
//        User user = userService.findUser(1);
//
//        List<Quiz> quizList = user.getQuizzes();
//        System.out.println(quizList.size());
//
//        List<Question> questions = quiz.getQuestions();
//        System.out.println(questions.size());

//        QuestionService questionService = (QuestionService) applicationContext.getBean("questionService");
//        Question question = questionService.findQuestion(4);
//
//        List<Answer> answers = question.getAnswers();
//        System.out.println(answers.size());

//    }

}
