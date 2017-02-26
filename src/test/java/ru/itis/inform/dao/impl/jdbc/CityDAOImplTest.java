package ru.itis.inform.dao.impl.jdbc;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import ru.itis.inform.dao.impl.config.TestDaoConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.itis.inform.models.rieltoryModel.City;
import java.util.logging.*;

import java.util.logging.Level;

import static org.junit.Assert.*;

/**
 * Created by Natalia on 26.02.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDaoConfig.class)
public class CityDAOImplTest {

    @Autowired
    private CityDAOImpl cityDAO;
    @Test
    public void save() throws Exception {
        City city = new City();
        city.setName("Kazannn");
        Integer id  = cityDAO.save(city);
        assertTrue(id > 0);

        Logger.getLogger(getClass().getName()).log(Level.INFO, "ID is equal: "+ id +" after inserting in test");

    }

    @Test
    public void update() throws Exception {
        City city = new City();
        city.setName("Moscowww");
        city.setId(3);
        cityDAO.update(city);

    }

    @Test
    public void find() throws Exception {
        City city= cityDAO.find(2);
        Logger.getLogger(getClass().getName()).log(Level.INFO, "City: " + city);

    }

    @Test
    public void delete() throws Exception {
        cityDAO.delete(2);
    }

    @Test
    public void findAll() throws Exception {
        cityDAO.findAll();
    }

}