package ru.itis.inform.dao.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.itis.inform.dao.impl.config.TestDaoConfig;
import ru.itis.inform.dao.repository.CityRepository;
import ru.itis.inform.models.City;

import java.util.List;

/**
 * Created by Natalia on 05.03.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDaoConfig.class)
public class CityRepositoryTest {

    @Autowired
    CityRepository cityRepository;

    @Test
    public void findAll() throws Exception {
        List<City> cities = (List<City>)cityRepository.findAll();
        System.out.println(cities);

    }
    @Test
    public void testGetCityIdByName() throws Exception {
       Integer id =  cityRepository.getCityId("Москва");
       System.out.print(id);
    }




}
