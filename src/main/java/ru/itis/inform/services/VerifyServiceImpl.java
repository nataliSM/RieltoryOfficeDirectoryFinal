package ru.itis.inform.services;

import ru.itis.inform.factories.DAOFactory;
import ru.itis.inform.DAOs.UserDAO;
import ru.itis.inform.factories.ServiceFactory;
import ru.itis.inform.models.User;

import javax.servlet.http.Cookie;

/**
 * Created by Natalia on 21.10.16.
 */
public class VerifyServiceImpl implements VerifyService {

    @Override
    public boolean verifyUser(int id, String token) {
        UserDAO userDAO = DAOFactory.getInstance().getUserDAO();
        User user = userDAO.findUser(id);
        if (user == null) {
            return false;

        }

        if (!user.getToken().equals(token)) {
            return false;
        }

        return true;
    }

    public boolean isClientLogined (Cookie [] cookies) {
        String id = null;
        String token = null;


        if (cookies == null) {

            return false;
        }

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("id")) {
                id = cookie.getValue();
            }
            if (cookie.getName().equals("user_token")) {
                token = cookie.getValue();
            }
        }

        if (id == null || token == null) {

            return false;
        }


        if (verifyUser(Integer.valueOf(id), token)) {
            return true;
        }
        return false;
    }



}
