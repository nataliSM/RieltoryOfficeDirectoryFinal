package ru.itis.inform.services;

import javax.servlet.http.Cookie;

/**
 * Created by Natalia on 21.10.16.
 */
public interface VerifyService {
    boolean verifyUser (int id , String token);
    boolean isClientLogined(Cookie [] cookies);
}
