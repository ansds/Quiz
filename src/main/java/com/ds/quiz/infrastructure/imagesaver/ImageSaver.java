package com.ds.quiz.infrastructure.imagesaver;

import com.ds.quiz.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by DS on 05.04.2015.
 */
public interface ImageSaver {

    public void validateImage(MultipartFile image) throws Exception;

    public void saveImage(String imageName, MultipartFile image, User user) throws Exception;
}
