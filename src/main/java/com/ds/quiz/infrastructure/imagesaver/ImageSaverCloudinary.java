package com.ds.quiz.infrastructure.imagesaver;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ds.quiz.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by DS on 05.04.2015.
 */
public class ImageSaverCloudinary implements ImageSaver{

    private Cloudinary cloudinary;

    public ImageSaverCloudinary(String cloud_name, String api_key, String api_secret) {
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloud_name,//"dqonofaej",
                "api_key", api_key,//"296763187689481",
                "api_secret", api_secret)//"5YdtbUWTjL7wCX7z8j8qLS7UcF4")
        );
    }

    @Override
    public void validateImage(MultipartFile image) throws Exception {
        if(!image.getContentType().equals("image/jpeg")) {
            throw new Exception("Only JPG images accepted");
        }
    }

    @Override
    public void saveImage(String imageName, MultipartFile image, User user) throws Exception {
        File file = new File(imageName);
        file.createNewFile();
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(image.getBytes());
        fos.flush();
        fos.close();
        List<String> q = new ArrayList<String>();
        q.add(imageName);
        Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.asMap("public_id", imageName));
        user.setImageLink((String) uploadResult.get("url"));
    }
}
