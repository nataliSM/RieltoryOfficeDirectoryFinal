package ru.itis.inform.DAOs;

import com.sun.org.apache.regexp.internal.RE;
import ru.itis.inform.factories.ServiceFactory;
import ru.itis.inform.models.rieltoryModel.*;
import ru.itis.inform.services.DataBaseConnectionServices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Natalia on 05.11.16.
 */
public class OffersDAOImpl  implements  OffersDAO{
private Connection connection;

    public OffersDAOImpl(Connection connection){

        this.connection = connection;
    }
    @Override
    public List<Offer> getAllOffersWithParams(int countOfRoom, String condition, String repair, String cityName,Integer startCost, Integer endCost) {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM full_offers WHERE city_name = ? AND count_of_room = ? AND condition = ? AND repair = ? AND cost BETWEEN ? AND ? ";
        List<Offer> offers = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cityName);
            preparedStatement.setInt(2,countOfRoom);
            preparedStatement.setString(3,condition);
            preparedStatement.setString(4,repair);
            preparedStatement.setInt(5, startCost);
            preparedStatement.setInt(6,endCost);
            preparedStatement.executeQuery();

            ResultSet resultSet = preparedStatement.executeQuery();
            offers = parseResultSet(resultSet);

        } catch (SQLException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, sql, e);
        }


        return offers;
    }

    private List<Offer> parseResultSet (ResultSet resultSet) {
        List<Offer> offers = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Offer offer = new Offer();
                Integer id = resultSet.getInt("id_flat");
                Integer cost = resultSet.getInt("cost");
                Integer traiderId = resultSet.getInt("trader_id");
                String traderName = resultSet.getString("trader_name");
                String traderPhone = resultSet.getString("trader_phone");
                Integer addressId = resultSet.getInt("address_id");
                Integer cityId = resultSet.getInt("city_id");
                Integer streetId = resultSet.getInt("street_id");
                String streetName = resultSet.getString("street_name");
                Integer house = resultSet.getInt("house");
                Integer flat = resultSet.getInt("flat");
                Integer featuresId = resultSet.getInt("features_id");

                offer.setId(id);
                offer.setCost(cost);

                Address address = new Address();
                address.setId(addressId);
                address.setFlat(flat);
                address.setHouse(house);
                City city = new City(cityId, resultSet.getString("city_name"));
                address.setCity(city);
                Street street = new Street(streetId, streetName, city);
                address.setStreet(street);

                offer.setAddress(address);

                Trader trader = new Trader(traiderId, traderName, traderPhone);
                offer.setTrader(trader);

                Feature feature = new Feature(featuresId, resultSet.getInt("count_of_room"), resultSet.getString("condition"), resultSet.getString("repair"));
                offer.setFeature(feature);

                offers.add(offer);
            }
        } catch (SQLException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, resultSet.toString(), e);
        }

        return offers;
    }

    //сохранение в бд
    public int save (Offer offer)
    {
        String sql = "INSERT INTO offers (address_id, features_id, cost, trader_id) VALUES (?, ?, ?, ?) RETURNING id_flat";
        Integer id = 0;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, offer.getAddress().getId());
            preparedStatement.setInt(2, offer.getFeature().getId());
            preparedStatement.setInt(3, offer.getCost());
            preparedStatement.setInt(4, offer.getTrader().getId());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next())
            {
                id = resultSet.getInt("id_flat");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

//получит всех
    @Override
    public List<Offer> getAll() {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM full_offers ORDER BY id_flat"; ;
        List<Offer> offers = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.executeQuery();
            ResultSet resultSet = null;
            resultSet = preparedStatement.executeQuery();
            offers = parseResultSet(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return offers;
    }
//удаление из бд выбранной строки
    public void delete (Integer id)
    {

        String sql = "DELETE FROM offers WHERE id_flat = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // изменение стоимости квартиры
    public void update(Integer id,Integer cost)
    {
        String sql = "UPDATE offers  SET cost = ? WHERE id_flat = ? ";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            try {
                preparedStatement.setInt(1,cost);
                preparedStatement.setInt(2,id);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
