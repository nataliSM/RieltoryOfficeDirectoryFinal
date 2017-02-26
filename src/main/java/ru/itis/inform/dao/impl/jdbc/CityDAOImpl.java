package ru.itis.inform.dao.impl.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import ru.itis.inform.dao.CityDAO;
import ru.itis.inform.models.rieltoryModel.City;


import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Natalia on 05.11.16.
 */
@Component("jdbc.city.dao")
public class CityDAOImpl implements CityDAO {
    private JdbcTemplate template;

    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM city";

    private RowMapper<City> cityRowMapper = new RowMapper<City>() {
        public City mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            return new City(resultSet.getInt("city_id"),
                    resultSet.getString("city_name"));

        }

    };

    @Autowired
    public CityDAOImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public int getCityId(String cityName) {
        String sql = "SELECT city_id FROM city WHERE city_name = ? ";
        City city = template.queryForObject(sql, new Object[]{cityName}, cityRowMapper);
        return city.getId();


    }


    @Override
    public Integer save(City city) {
        String sql = "INSERT INTO city(city_name) VALUES (?)";

        KeyHolder holder = new GeneratedKeyHolder();
        template.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, city.getName());
            return preparedStatement;
        }, holder);
        return (Integer) holder.getKeys().get("SCOPE_IDENTITY()");

//        KeyHolder keyHolder = new GeneratedKeyHolder();
//        template.update(sql, new Object[]{city.getName()}, keyHolder);
//        return keyHolder.getKey().intValue();
    }

    @Override
    public void update(City city) {
        String sql = "UPDATE city  SET sity_name = ? WHERE city_id = ? ";
        template.query(sql, new Object[]{city.getName(), city.getId()}, cityRowMapper);

    }

    @Override
    public City find(Integer id) {
        String sql = "SELECT * FROM city WHERE city_id = ?";
        City city = template.queryForObject(sql, new Object[]{id},cityRowMapper);
        return city;
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM city WHERE city_id = ?";

        template.update(sql, new Object[]{id});

    }

    @Override
    public List<City> findAll() {

        return template.query(SQL_SELECT_ALL, cityRowMapper);
    }


}
