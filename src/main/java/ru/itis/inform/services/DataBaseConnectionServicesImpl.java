package ru.itis.inform.services; /**
 * Created by Natalia on 09.10.16.
 */

import ru.itis.inform.DAOs.Database;

import java.sql.Connection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DataBaseConnectionServicesImpl implements DataBaseConnectionServices {
    private  Connection connection;


    public Connection getConnection(Database database)
    {

        Connection connection = null;
        String url = database.getUrlString();
        String user = database.getUser();
        String password = database.getPassword();


        try{
            Class.forName(database.getDriver());
            Logger.getLogger(getClass().getName()).log(Level.INFO, "Driver found");
            connection = DriverManager.getConnection(url, user, password);
            Logger.getLogger(getClass().getName()).log(Level.INFO, "Connection setup ");
        } catch (ClassNotFoundException e) {

            Logger.getLogger(getClass().getName()).log(Level.SEVERE,null,e);

        } catch (SQLException e) {

            Logger.getLogger(getClass().getName()).log(Level.SEVERE,null,e);
        }
        return connection;

    }

}
