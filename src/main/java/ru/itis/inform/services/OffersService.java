package ru.itis.inform.services;

import ru.itis.inform.models.City;
import ru.itis.inform.models.Offer;
import ru.itis.inform.models.Street;

import java.util.List;

/**
 * Created by Natalia on 06.11.16.
 */
public interface OffersService {
    public List<Offer> generateOfferces(int numberOfRooms, String condition, String repair, String cityName, Integer startCost,Integer endCost);
    public List<City> getAllCities ();
    public List<Street> getAllStreets ();
    public void save (Offer offer);
    public  List<Offer> getAll ();
    public void delete(Integer id);
    public void update(Integer id, Integer cost);
    public Offer findOffer(Integer id);
}
