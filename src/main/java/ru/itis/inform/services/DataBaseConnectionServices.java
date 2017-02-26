package ru.itis.inform.services;

import ru.itis.inform.dao.Database;


import java.sql.Connection;

/**
 * Created by Natalia on 09.10.16.
 */
public interface DataBaseConnectionServices {
    Connection getConnection(Database database);


}
