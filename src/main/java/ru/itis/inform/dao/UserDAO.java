package ru.itis.inform.dao;
import ru.itis.inform.models.User;

/**
 * Created by Natalia on 09.10.16.
 */
public interface UserDAO {

    public User findUser(String username);
    public void save (User user);
    public void saveTokenForUser(int id, String token);
    User findUser (int id);
}
