package com.ds.quiz.controller;

import com.ds.quiz.model.User;
import com.ds.quiz.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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


/**
 * Created by DS on 07.03.2015.
 */
@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Resource(name = "userService")
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String createUserAccount(Model model) {
        model.addAttribute(new User());
        return "registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createUserFromForm(@Valid User user, BindingResult bindingResult,
                                     @RequestParam(value = "image", required = false)MultipartFile image) throws Exception {
        if(bindingResult.hasErrors()) {
            return "registration";
        }
        userService.addUser(user);

        try {
            if (!image.isEmpty()) {
                validateImage(image);

                saveImage(user.getId() + ".jpg", image);
            }
        } catch (Exception e) {
            bindingResult.reject(e.getMessage());
            return "registration";
        }

        return "redirect:/login";
    }

    private void validateImage(MultipartFile image) throws Exception {
        if(!image.getContentType().equals("image/jpeg")) {
            throw new Exception("Only JPG images accepted");
        }
    }

    private void saveImage(String imageName, MultipartFile image) throws IOException {
        File file = new File("D:\\" + imageName);
        file.createNewFile();
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(image.getBytes());
        fos.flush();
        fos.close();
    }

}
