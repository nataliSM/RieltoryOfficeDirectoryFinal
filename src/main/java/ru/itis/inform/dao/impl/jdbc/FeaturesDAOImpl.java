package ru.itis.inform.dao.impl.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import ru.itis.inform.dao.FeaturesDAO;
import ru.itis.inform.models.Feature;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Natalia on 05.11.16.
 */
@Component("jdbc.features.dao")
public class FeaturesDAOImpl implements FeaturesDAO {



    private JdbcTemplate template;
    @Autowired
    public FeaturesDAOImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    public Integer save(Feature feature) {

        String sql = "INSERT INTO features(count_of_room, condition, repair) VALUES (?, ?, ?) RETURNING features_id";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(sql, new Object[]{feature.getCountOfRoom(),feature.getCondition(),feature.getRepair()}, keyHolder);
        return keyHolder.getKey().intValue();

    }

    @Override
    public void update(Feature feature) {

    }

    @Override
    public Feature find(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Feature> findAll() {
        return null;
    }



}