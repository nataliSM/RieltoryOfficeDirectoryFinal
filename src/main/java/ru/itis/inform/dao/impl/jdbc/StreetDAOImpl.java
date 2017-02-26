package ru.itis.inform.dao.impl.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.itis.inform.dao.StreetDAO;
import ru.itis.inform.models.rieltoryModel.City;
import ru.itis.inform.models.rieltoryModel.Street;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component("jdbc.street.dao")
public class StreetDAOImpl implements StreetDAO {

    private JdbcTemplate template;
    private final String SQL_FIND_ALL = "SELECT * FROM fullstreet";
    @Autowired
    public  StreetDAOImpl(DataSource dataSource){
        this.template = new JdbcTemplate(dataSource);
    }

    private RowMapper<Street> streetRowMapper  = new RowMapper<Street>() {
        public Street mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            return new Street(resultSet.getInt("street_id"),
                    new City(resultSet.getInt("city_id"),resultSet.getString("city_name")),
                    resultSet.getString("street_name"));


            }

    };

    public int getStreetId(String streetName,Integer cityId) {
        String sql = "SELECT street_id FROM street WHERE street_name = ? AND city_id = ?";

        Street street1 = template.queryForObject(sql, new Object[]{streetName,cityId},streetRowMapper);
        return street1.getId();
    }

    @Override
    public Integer save(Street street) {
        return null;
    }

    @Override
    public void update(Street street) {

    }

    @Override
    public Street find(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Street> findAll() {
        return template.query(SQL_FIND_ALL,streetRowMapper);
    }
}
