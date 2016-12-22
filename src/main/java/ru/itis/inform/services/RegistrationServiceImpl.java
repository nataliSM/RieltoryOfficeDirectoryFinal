package ru.itis.inform.services;

import org.apache.commons.codec.digest.DigestUtils;
import ru.itis.inform.factories.DAOFactory;
import ru.itis.inform.DAOs.UserDAO;
import ru.itis.inform.models.User;

/**
 * Created by Natalia on 10.10.16.
 */
public class RegistrationServiceImpl implements RegistrationService {

    public  String md5Apache(String password) {
        String md5Hex = DigestUtils.md5Hex(password);

        return md5Hex;
    }
    @Override
    public void registrateUser(String username, String password) {
        String hexPassword = md5Apache(password);
        User user = new User(username, hexPassword);
        UserDAO userDAO = DAOFactory.getInstance().getUserDAO();
        userDAO.save(user);
    }
}
