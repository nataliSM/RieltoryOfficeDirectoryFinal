package ru.itis.inform.DAOs;

import com.sun.media.jfxmediaimpl.platform.ios.IOSMediaPlayer;
import ru.itis.inform.factories.ServiceFactory;
import ru.itis.inform.models.rieltoryModel.Address;
import ru.itis.inform.services.DataBaseConnectionServices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Natalia on 05.11.16.
 */
public class AddressDAOImpl implements AddressDAO {
    private Connection connection;

    public AddressDAOImpl(Connection connection) {

        this.connection = connection;
    }

    @Override
    public Address getAddress(int id) {
        return null;
    }

    public int save (Address address){
        String sql = "INSERT INTO address(city_id,street_id,house,flat) VALUES(?, ?, ?, ?) RETURNING id_address";
        Integer id = 0;
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,address.getCity().getId());
            preparedStatement.setInt(2,address.getStreet().getId());
            preparedStatement.setInt(3,address.getHouse());
            preparedStatement.setInt(4,address.getFlat());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                id = resultSet.getInt("id_address");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    public int findAddress(Address address){
        Integer id = -1;

        String sql = "SELECT id_address FROM address WHERE city_id = ? AND street_id = ? AND house = ? AND flat = ? ";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,address.getCity().getId());
            preparedStatement.setInt(2,address.getStreet().getId());
            preparedStatement.setInt(3,address.getHouse());
            preparedStatement.setInt(4,address.getFlat());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                id = resultSet.getInt("id_address");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }
}
