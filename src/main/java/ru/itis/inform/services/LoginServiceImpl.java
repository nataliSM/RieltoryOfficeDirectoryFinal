package ru.itis.inform.services;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

import ru.itis.inform.dao.UserDAO;
import ru.itis.inform.models.User;

import javax.servlet.http.Cookie;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Natalia on 09.10.16.
 */
@Component
public class LoginServiceImpl implements LoginService
{
    private String currentToken;
    private ArrayList<Cookie> cookies;
    private User currentUser;

    public static String md5Apache(String password) {
        String md5Hex = DigestUtils.md5Hex(password);

        return md5Hex;
    }

    @Override
    public boolean verifyUser(String username, String password) {
        UserDAO userDAO = null;
        User user = userDAO.findUser(username);

        if (user != null) {
            this.currentUser = user;
            generateCookiesForUser(user);
            return true;
        }
        return false;


    }

    @Override
    public  ArrayList<Cookie> getCookies() {

        return this.cookies;
    }

    public void generateCookiesForUser(User currentUser)
    {
        String idString = String.valueOf(currentUser.getId());
        String tokenString = generateToken();
        Cookie idCookie = new Cookie("id", idString);
        idCookie.setMaxAge(30*60);
        Cookie tokenCookie = new Cookie("user_token", tokenString);
        tokenCookie.setMaxAge(30*60);

        ArrayList<Cookie> cookies= new ArrayList<>();
        cookies.add(idCookie);
        cookies.add(tokenCookie);

        this.cookies = cookies;

    }

    private String generateToken ()
    {
        Random random = new SecureRandom();
        char[] result = new char[32];
        for (int i = 0; i < result.length; i++) {
            // picks a random index out of character set > random character
            char[] characterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
            int randomCharIndex = random.nextInt(characterSet.length);
            result[i] = characterSet[randomCharIndex];
        }
        this.currentToken = new String(result);
        saveToken(currentToken);
        return this.currentToken;
    }

    private void saveToken(String currentToken){
        UserDAO userDao = null;
        userDao.saveTokenForUser(currentUser.getId() ,currentToken);

    }


    }



