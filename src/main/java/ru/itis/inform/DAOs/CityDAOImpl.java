package ru.itis.inform.DAOs;

import ru.itis.inform.factories.RieltoryFactory;
import ru.itis.inform.factories.ServiceFactory;
import ru.itis.inform.models.rieltoryModel.City;
import ru.itis.inform.services.DataBaseConnectionServices;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Natalia on 05.11.16.
 */
public class CityDAOImpl implements CityDAO {
    private Connection connection ;

    public CityDAOImpl(Connection connection)  {

        this.connection = connection;
    }

    @Override
    public int getCityId(String cityName) {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT city_id FROM city WHERE city_name = ? ";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,cityName);
            ResultSet resultSet = null;
            try {
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next())
                {
                    return resultSet.getInt("city_id");

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public List<City> getAll(){
        List<City> cityList = new ArrayList<>();
        String sql = "SELECT * FROM city";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                City city = new City();

                    city.setId(resultSet.getInt("city_id"));
                    city.setName(resultSet.getString("city_name"));

                cityList.add(city);


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cityList;
    }
}
