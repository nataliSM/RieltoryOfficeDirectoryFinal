package ru.itis.inform.DAOs;


import ru.itis.inform.factories.ServiceFactory;
import ru.itis.inform.models.User;
import ru.itis.inform.services.DataBaseConnectionServices;


import javax.jws.soap.SOAPBinding;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Created by Natalia on 09.10.16.
 */
public class UserDaoImpl implements UserDAO{
    private Connection connection ;




    public UserDaoImpl(Connection connection) {

        this.connection = connection;
    }

    public UserDaoImpl() {

    }

    @Override
    public User findUser(String username) {
        boolean isFind = false;
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM users WHERE username = ?");
            preparedStatement.setString(1, username);
            User user =findUserWithPrepareStatement(preparedStatement);
            return user;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



        public void save(User user) {
            if (user == null)
            {
                throw new IllegalArgumentException();
            }

            String sql = "INSERT INTO users(username, password) VALUES (?, ?)";
            String userName = user.getName();
            String userPassword = user.getPassword();

            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, userName);
                preparedStatement.setString(2, userPassword);
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        public void saveTokenForUser(int id, String token) {

            if (id <= 0) {
                throw new IllegalArgumentException();
            }
            String sql = "UPDATE users SET user_token = ? WHERE id = ?;";

            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, token);
                preparedStatement.setInt(2,id);
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }


        }

    @Override
    public User findUser(int id) {

        boolean isFind = false;
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM users WHERE ( id = ? )");
            preparedStatement.setInt(1,id);

            User user = findUserWithPrepareStatement(preparedStatement);
            return user;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private User findUserWithPrepareStatement(PreparedStatement preparedStatement)
    {

        ResultSet resultSet = null;
        try {
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {
                String name = resultSet.getString("username");
                String password = resultSet.getString("password");
                int id = resultSet.getInt("id");
                String token = resultSet.getString("user_token");
                User user = new User(name, password);
                user.setToken(token);
                user.setId(id);
                return user;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

       return  null;
    }

    public String getTokenFromUser(int id) {

            String sql = "SELECT user_token FROM users WHERE id = ?;";


            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    String token = resultSet.getString("user_token");
                    return token;
                }



            } catch (SQLException e) {
                e.printStackTrace();
            }

            return null;

        }


}
