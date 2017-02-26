package ru.itis.inform.dao.impl.jdbc;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import ru.itis.inform.dao.OffersDAO;
import ru.itis.inform.models.rieltoryModel.*;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Natalia on 05.11.16.
 */
//@Component ("jdbc.offers.dao")
public class OffersDAOImpl  implements OffersDAO {
    private JdbcTemplate template;


    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM full_offers ORDER BY id_flat";

    //language=SQL
    private  final String SQL_SELECT_ALL_WITH_PARAM = "SELECT * FROM full_offers WHERE city_name = ? AND count_of_room = ? AND condition = ? AND repair = ? AND cost BETWEEN ? AND ? ";

    @Autowired
    public OffersDAOImpl(DataSource dataSource){
        this.template = new JdbcTemplate(dataSource);
    }

    private RowMapper<Offer> offerRowMapper = new RowMapper<Offer>() {
        public Offer mapRow(ResultSet resultSet, int rowNum) throws SQLException {
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

            return offer;
        }

    };
    @Override
    public List<Offer> getAllOffersWithParams(int countOfRoom, String condition, String repair, String cityName,Integer startCost, Integer endCost) {


        return template.query(SQL_SELECT_ALL_WITH_PARAM, new Object[]{cityName, countOfRoom, condition, repair, startCost, endCost },offerRowMapper );
    }


    //сохранение в бд
    public Integer save (Offer offer)
    {
        String sql = "INSERT INTO offers (address_id, features_id, cost, trader_id) VALUES (?, ?, ?, ?) RETURNING id_flat";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(sql, new Object[]{offer.getAddress().getId(), offer.getFeature().getId(), offer.getCost(), offer.getTrader().getId()}, keyHolder);

        return keyHolder.getKey().intValue();
    }

    @Override
    public void update(Offer offer) {

    }

    @Override
    public Offer find(Integer id) {
        return null;
    }


//удаление из бд выбранной строки
    public void delete (Integer id)
    {
        String sql = "DELETE FROM offers WHERE id_flat = ?";
        template.query(sql, new Object[]{id}, offerRowMapper);
    }

    @Override
    public List<Offer> findAll() {
        return template.query(SQL_SELECT_ALL, offerRowMapper);
    }


    // изменение стоимости квартиры
    public void update(Integer id,Integer cost)
    {
        String sql = "UPDATE offers  SET cost = ? WHERE id_flat = ? ";
        template.query(sql, new Object[]{cost, id}, offerRowMapper);


    }

}
