package ru.itis.inform.services;

import ru.itis.inform.models.rieltoryModel.City;
import ru.itis.inform.models.rieltoryModel.Offer;
import ru.itis.inform.models.rieltoryModel.Street;

import java.util.List;

/**
 * Created by Natalia on 06.11.16.
 */
public interface OfferseGeneratorService {
    public List<Offer> generateOfferces(int numberOfRooms, String condition, String repair, String cityName, Integer startCost,Integer endCost);
    public List<City> getAllCities ();
    public List<Street> getAllStreets ();
    public void save (Offer offer);
    public  List<Offer> getAll ();
    public void delete(Integer id);
    public void update(Integer id, Integer cost);
    public Offer findOffer(Integer id);
}
