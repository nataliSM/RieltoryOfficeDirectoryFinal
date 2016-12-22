package ru.itis.inform.DAOs;


import ru.itis.inform.models.rieltoryModel.Offer;
import ru.itis.inform.models.rieltoryModel.OffersTable;

import java.util.List;

/**
 * Created by Natalia on 05.11.16.
 */
public interface OffersDAO {
    List<Offer> getAllOffersWithParams (int countOfRoom, String condition, String repair, String cityName,Integer startCost, Integer endCost);
    public int save (Offer offer);
    public List<Offer> getAll();
    public void delete (Integer id);
    public void update(Integer id, Integer cost);
}
