package ru.itis.inform.factories;

import ru.itis.inform.dao.Database;
import ru.itis.inform.dao.UserDAO;
import ru.itis.inform.dao.UserDaoImpl;
import ru.itis.inform.services.DataBaseConnectionServices;
import ru.itis.inform.services.DataBaseConnectionServicesImpl;

import java.sql.Connection;

/**
 * Created by Natalia on 21.10.16.
 */
public class DAOFactory {
    private static DAOFactory ourInstance = new DAOFactory();

    public static DAOFactory getInstance() {

        return ourInstance;
    }

    public UserDAO getUserDAO(Connection connection) {
         return new UserDaoImpl(connection);
    }

    public UserDAO getUserDAO() {
        Connection connection = getConnection();
        return new UserDaoImpl(connection);
    }

    public Connection getConnection(){
        Connection connection;

        DataBaseConnectionServices dataBaseConnectionServices = new DataBaseConnectionServicesImpl();
       connection =  dataBaseConnectionServices.getConnection(Database.ApplicationDatabase);
        return connection;
    }

}
