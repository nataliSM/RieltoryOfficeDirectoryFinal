package ru.itis.inform.dao;

import ru.itis.inform.models.rieltoryModel.Street;

import java.util.List;

/**
 * Created by Natalia on 05.11.16.
 */
public interface StreetDAO extends BaseDao<Street> {
    public int getStreetId(String streetName, Integer cityId);
}