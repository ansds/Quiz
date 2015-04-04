package com.ds.quiz.main;

import com.ds.quiz.dao.UserDao;
import com.ds.quiz.infrastructure.crypt.CryptUtils;
import com.ds.quiz.model.Answer;
import com.ds.quiz.model.Question;
import com.ds.quiz.model.Quiz;
import com.ds.quiz.model.User;
import com.ds.quiz.service.AnswerService;
import com.ds.quiz.service.QuestionService;
import com.ds.quiz.service.QuizService;
import com.ds.quiz.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.List;

/**
 * Created by DS on 27.02.2015.
 */
public class Main {
//    public static void main(String[] args) {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("appContext.xml");
//        //UserService userService = (UserService) applicationContext.getBean("userService");
////        System.out.println(userService.findUsers());
////
////        User user = new User();
////        user.setUsername("dmitry");
////        user.setEmail("ds.@gmail.com");
////        String salt = CryptUtils.generateSalt();
////        String password = CryptUtils.cryptPassword("passw", salt);
////        user.setSalt(salt);
////        user.setPassword(password);
////
////
////
////        userService.addUser(user);
////        System.out.println(userService.findUsers());
//
//        QuizService quizService = (QuizService) applicationContext.getBean("quizService");
//        QuestionService questionService = (QuestionService) applicationContext.getBean("questionService");
//        AnswerService answerService = (AnswerService) applicationContext.getBean("answerService");
//        answerService.findAnswers();
//        questionService.findQuestion();
//        List<Quiz> quizList = quizService.findQuizzes();
//
//        List<Question> questions = quizList.get(0).getQuestions();
//
//        System.out.println(questions);
//
//        List<Answer> answers = questions.get(0).getAnswers();
//
//        System.out.println(answers);
//        //List<Quiz> quizList = quizService.findQuizzes();
////        System.out.println(quizList.get(0));
////        List<Question> questions = quizList.get(0).getQuestions();
////        System.out.println(questions);
//    }
public static void main(String[] args) {
    ApplicationContext applicationContext = new FileSystemXmlApplicationContext("C:\\Users\\DS\\Downloads\\eshop-master\\Quiz\\src\\main\\webapp\\WEB-INF\\spring\\appContext.xml");
}


}
