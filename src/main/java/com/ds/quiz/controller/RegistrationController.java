package com.ds.quiz.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import com.ds.quiz.infrastructure.imagesaver.ImageSaver;
import com.ds.quiz.model.User;
import com.ds.quiz.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;


/**
 * Created by DS on 07.03.2015.
 */
@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Resource(name = "userService")
    private UserService userService;
    @Resource(name = "imageSaver")
    private ImageSaver imageSaver;

    @RequestMapping(method = RequestMethod.GET)
    public String createUserAccount(Model model) {
        model.addAttribute(new User());
        return "registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createUserFromForm(@Valid User user, BindingResult bindingResult,
                                     @RequestParam(value = "image", required = false)MultipartFile image) throws Exception {
        if(bindingResult.hasErrors()) {
            for (Object object : bindingResult.getAllErrors()) {
                if(object instanceof FieldError) {
                    FieldError fieldError = (FieldError) object;

                    System.out.println(fieldError.getField() + " " + fieldError.getCode());
                }

                if(object instanceof ObjectError) {
                    ObjectError objectError = (ObjectError) object;

                    System.out.println(objectError.getObjectName() + " " + objectError.getCode());
                }
            }
            return "registration";

        }
        try {
            if (!image.isEmpty()) {
                imageSaver.validateImage(image);
                imageSaver.saveImage(String.valueOf(user.getId()), image, user);
            }
        } catch (Exception e) {
            bindingResult.reject(e.getMessage());
            return "registration";
        }
        userService.addUser(user);
        return "redirect:/login";
    }

}
