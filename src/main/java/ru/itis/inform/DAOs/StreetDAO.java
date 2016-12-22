package ru.itis.inform.DAOs;

import ru.itis.inform.models.rieltoryModel.Street;

import java.util.List;

/**
 * Created by Natalia on 05.11.16.
 */
public interface StreetDAO {
    public List<Street> getAll();
    public int getStreetId(String streetName, Integer cityId);
}
