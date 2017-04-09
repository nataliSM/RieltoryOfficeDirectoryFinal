package ru.itis.inform.dao;


import ru.itis.inform.models.Offer;

import java.util.List;

/**
 * Created by Natalia on 05.11.16.
 */
public interface OffersDAO extends BaseDao<Offer> {
    List<Offer> getAllOffersWithParams (int countOfRoom, String condition, String repair, String cityName,Integer startCost, Integer endCost);
    public Integer save (Offer offer);

    public void update(Integer id, Integer cost);
}
