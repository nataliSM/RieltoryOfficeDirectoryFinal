package ru.itis.inform.DAOs;

import ru.itis.inform.models.rieltoryModel.City;

import java.util.List;

/**
 * Created by Natalia on 05.11.16.
 */
public interface CityDAO {
    int getCityId(String cityName);
    public List<City> getAll();
}
