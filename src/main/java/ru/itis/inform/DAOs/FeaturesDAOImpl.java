package ru.itis.inform.DAOs;

import ru.itis.inform.factories.ServiceFactory;
import ru.itis.inform.models.rieltoryModel.Feature;
import ru.itis.inform.services.DataBaseConnectionServices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Natalia on 05.11.16.
 */
public class FeaturesDAOImpl implements  FeaturesDAO {
    private Connection connection;


    public FeaturesDAOImpl(Connection connection) {
        this.connection = connection;
    }

    public int save(Feature feature) {
        String sql = "INSERT INTO features(count_of_room, condition, repair) VALUES (?, ?, ?) RETURNING features_id";
        Integer id = 0;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, feature.getCountOfRoom());
            preparedStatement.setString(2, feature.getCondition());
            preparedStatement.setString(3, feature.getRepair());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getInt("features_id");
            }
        } catch (SQLException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
        }
        return id;
    }




}