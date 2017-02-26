package ru.itis.inform.dao.impl.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import ru.itis.inform.dao.AddressDAO;
import ru.itis.inform.models.rieltoryModel.Address;

import org.springframework.jdbc.core.RowMapper;
import ru.itis.inform.models.rieltoryModel.City;
import ru.itis.inform.models.rieltoryModel.Street;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Natalia on 05.11.16.
 */
@Component("jdbc.addres.dao")
public class AddressDAOImpl implements AddressDAO {

    private JdbcTemplate template;

    //language=SQL
    private final String SQL_SELECT_BY_ID = "SELECT id_address FROM address WHERE city_id = ? AND street_id = ? AND house = ? AND flat = ? ";

private RowMapper<Address> addressRowMapper = new RowMapper<Address>() {
    public Address mapRow(ResultSet resultSet, int rowNum) throws SQLException{
        return new Address(resultSet.getInt("id_address"),
                new City(resultSet.getInt("city_id")),
                new Street(resultSet.getInt("street_id")),
                resultSet.getInt("house"),
                resultSet.getInt("flat"));

    }


    };

    @Autowired
    public AddressDAOImpl(DataSource dataSource) {

        this.template = new JdbcTemplate(dataSource);
    }

    public Integer save (Address address){
        String sql = "INSERT INTO address(city_id,street_id,house,flat) VALUES(?, ?, ?, ?) RETURNING id_address";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(sql, new Object[]{address.getCity().getId(), address.getStreet().getId(), address.getHouse(), address.getFlat()}, keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public void update(Address address) {

    }

    @Override
    public Address find(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Address> findAll() {
        return null;
    }

    public int findAddress(Address address){
        Address address1 = template.queryForObject(SQL_SELECT_BY_ID, new Object[]{address.getCity().getId(), address.getStreet().getId(), address.getHouse(), address.getFlat()}, addressRowMapper);
        return  address1.getId();


    }
}
