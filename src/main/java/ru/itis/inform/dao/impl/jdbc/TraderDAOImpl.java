package ru.itis.inform.dao.impl.jdbc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import ru.itis.inform.dao.TraderDAO;
import ru.itis.inform.models.Trader;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Natalia on 06.11.16.
 */
@Component("jdbc.trader.dao")
public class TraderDAOImpl implements TraderDAO {
    private JdbcTemplate template;
    @Autowired
    public TraderDAOImpl(DataSource dataSource){
        this.template = new JdbcTemplate(dataSource);
    }

    private RowMapper<Trader> traderRowMapper  = new RowMapper<Trader>() {
        public Trader mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            return new Trader(resultSet.getInt("trader_id"),resultSet.getString("trader_name"),
                    resultSet.getString("trader_phone"));


        }

    };



    public Integer save (Trader trader)
    {
        String sql = "INSERT INTO trader (trader_name, trader_phone) VALUES (?, ?) RETURNING trader_id";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(sql, new Object[]{trader.getName(), trader.getPhoneNumber()}, keyHolder);
        return keyHolder.getKey().intValue();

    }

    @Override
    public void update(Trader trader) {

    }

    @Override
    public Trader find(Integer id) {
        String sql = "SELECT *  FROM trader WHERE trader_id = ?;";
        return template.queryForObject(sql, new Object[]{id}, traderRowMapper);

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Trader> findAll() {
        return null;
    }

    public int findTrader(Trader trader)
    {
        String  sql = "SELECT trader_id FROM trader WHERE trader_name = ? AND trader_phone = ?";

        Trader trader2 = template.queryForObject(sql, new Object[]{trader.getName(),trader.getPhoneNumber()},traderRowMapper);
        return trader2.getId();
    }

}
