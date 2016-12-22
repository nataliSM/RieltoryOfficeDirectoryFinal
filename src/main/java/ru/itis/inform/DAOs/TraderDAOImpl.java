package ru.itis.inform.DAOs;


import ru.itis.inform.factories.ServiceFactory;
import ru.itis.inform.models.rieltoryModel.Trader;
import ru.itis.inform.services.DataBaseConnectionServices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Natalia on 06.11.16.
 */
public class TraderDAOImpl implements TraderDAO {
    private Connection connection;

    public TraderDAOImpl(Connection connection) {

        this.connection = connection;
    }

    public Trader getTrader(Integer id)
    {
        String sql = "SELECT *  FROM trader WHERE trader_id = ?;";


        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("trader_name");
                String phone = resultSet.getString("trader_phone");
                Trader trader = new Trader(id, name, phone);
                return trader;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public int save (Trader trader)
    {
        String sql = "INSERT INTO trader (trader_name, trader_phone) VALUES (?, ?) RETURNING trader_id";
        Integer id = 0;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, trader.getName());
            preparedStatement.setString(2, trader.getPhoneNumber());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next())
            {
                id = resultSet.getInt("trader_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;

    }

    public int findTrader(Trader trader)
    {
        Integer id = -1;
        String  sql = "SELECT trader_id FROM trader WHERE trader_name = ? AND trader_phone = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,trader.getName());
            preparedStatement.setString(2,trader.getPhoneNumber());

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                id = resultSet.getInt("trader_id");
            }
        }
      catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

}
