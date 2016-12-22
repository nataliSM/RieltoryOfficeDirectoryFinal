package ru.itis.inform.DAOs;

import ru.itis.inform.factories.ServiceFactory;
import ru.itis.inform.models.rieltoryModel.City;
import ru.itis.inform.models.rieltoryModel.Street;
import ru.itis.inform.services.DataBaseConnectionServices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class StreetDAOImpl implements  StreetDAO{

    private Connection connection;

    public StreetDAOImpl(Connection connection) {
        this.connection = connection;
    }

    public List<Street> getAll(){
        List<Street> streetList = new ArrayList<>();

        String sql = "SELECT * FROM fullstreet";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Street street = new Street();
                City city = new City();

                street.setId(resultSet.getInt("street_id"));
                city.setId(resultSet.getInt("city_id"));
                city.setName(resultSet.getString("city_name"));
                street.setCity(city);
                street.setName(resultSet.getString("street_name"));

                streetList.add(street);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return streetList;
    }

    public int getStreetId(String streetName,Integer cityId) {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT street_id FROM street WHERE street_name = ? AND city_id = ?";
        Integer id = 0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,streetName);
            preparedStatement.setInt(2, cityId);
            ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next())
                {
                     id = resultSet.getInt("street_id");
                }
        } catch (SQLException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, preparedStatement.toString(), e);
        }
        return id;
    }

}
