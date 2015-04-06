package com.ds.quiz.controller;

import com.ds.quiz.dao.EntityDoesNotExistException;
import com.ds.quiz.infrastructure.imagesaver.ImageSaver;
import com.ds.quiz.model.Question;
import com.ds.quiz.model.Quiz;
import com.ds.quiz.model.Statistics;
import com.ds.quiz.model.User;
import com.ds.quiz.service.StatisticsService;
import com.ds.quiz.service.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by DS on 10.03.2015.
 */

@Controller
@RequestMapping(value = "/profile")
public class ProfileController {

    @Resource(name = "userService")
    private UserService userService;
    @Resource(name = "statisticsService")
    private StatisticsService statisticsService;
    @Resource(name = "imageSaver")
    private ImageSaver imageSaver;

    @RequestMapping(method = RequestMethod.GET)
    public String getUserProfile(Model model) throws EntityDoesNotExistException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User user = userService.findUser(username);
        model.addAttribute("user", user);
        model.addAttribute("statisticsList", statisticsService.findStatisticsByUser(user));
        return "profile";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String changeUserProfile(Model model,
                                    HttpServletRequest request,
                                    @RequestParam(value = "image", required = false) MultipartFile image) throws EntityDoesNotExistException {
        String newUsername = request.getParameter("username");
        String newEmail = request.getParameter("email");
//        String newPassword = request.getParameter("password");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User user = userService.findUser(username);
        if(newUsername != null) {
            user.setUsername(newUsername);
        }
        if(newEmail != null) {
            user.setEmail(newEmail);
        }
        if(!image.isEmpty()) {
            try {
                imageSaver.validateImage(image);
                imageSaver.saveImage(String.valueOf(user.getId()), image, user);
            } catch (Exception e) {
                return "profile";
            }
        }
        userService.updateUser(user);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User userDetails = (User) authentication.getPrincipal();
        userDetails.setUsername(user.getUsername());
        return getUserProfile(model);
    }

}
