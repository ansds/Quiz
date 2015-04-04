package com.ds.quiz.infrastructure.crypt;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by DS on 02.03.2015.
 */
public class CryptUtils {

    public static String generateSalt() {
        StringBuilder salt = new StringBuilder();
        Random random = new Random();
        int length = random.nextInt(6) + 5;
        for(int i = 0; i < length; i++) {
            salt.append(Character.toChars(random.nextInt(94) + 33));
        }
        return salt.toString();
    }

    private static String getHash(String str) {
        MessageDigest md5;
        StringBuffer hexString = new StringBuffer();
        try {
            md5 = MessageDigest.getInstance("MD5");
            md5.reset();
            md5.update(str.getBytes());

            byte[] messageDigest = md5.digest();

            for(int i = 0; i< messageDigest.length; i++) {
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));

            }
            System.out.print(DatatypeConverter.printHexBinary(messageDigest));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hexString.toString();
    }

    public static String cryptPassword(String password, String salt) {
        String cryptedPassword = getHash(password);
        String cryptedSalt = getHash(salt);
        return getHash(cryptedPassword + cryptedSalt);
    }

}
