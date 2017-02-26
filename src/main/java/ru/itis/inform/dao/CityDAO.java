package ru.itis.inform.dao;

import ru.itis.inform.models.rieltoryModel.City;

import java.util.List;

/**
 * Created by Natalia on 05.11.16.
 */
public interface CityDAO extends BaseDao<City> {
    int getCityId(String cityName);
}
