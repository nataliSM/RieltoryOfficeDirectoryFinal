package ru.itis.inform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.inform.dao.*;
import ru.itis.inform.dao.OffersDAO;
import ru.itis.inform.models.rieltoryModel.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Natalia on 05.11.16.
 */
@Component
public class OfferceGeneratorServicesImpl implements OfferseGeneratorService{
    private TraderDAO traderDAO;
    private AddressDAO addressDAO;
    private FeaturesDAO featuresDAO;
    private OffersDAO offersDAO;
    private CityDAO cityDAO;
    private StreetDAO streetDAO;

    public OfferceGeneratorServicesImpl() {
    }

    @Autowired
    public OfferceGeneratorServicesImpl(TraderDAO traderDAO,
                                        AddressDAO addressDAO,
                                        FeaturesDAO featuresDAO,
                                        OffersDAO offersDAO,
                                        CityDAO cityDAO,
                                        StreetDAO streetDAO)
    {
        this.traderDAO = traderDAO;
        this.addressDAO = addressDAO;
        this.featuresDAO = featuresDAO;
        this.offersDAO = offersDAO;
        this.cityDAO = cityDAO;
        this.streetDAO = streetDAO;
    }

    public OfferceGeneratorServicesImpl(OffersDAO offersDAO) {
        this.offersDAO = offersDAO;
    }

    public List<Offer> generateOfferces(int numberOfRooms, String condition, String repair, String cityName, Integer startCost, Integer endCost)
    {
        return offersDAO.getAllOffersWithParams(numberOfRooms, condition, repair, cityName,startCost,endCost);
    }



    @Override
    public List<City> getAllCities() {
        return cityDAO.findAll();
    }

    @Override
    public List<Street> getAllStreets() {
        return streetDAO.findAll();
    }

    @Override
    public void save(Offer offer) {
        int id = traderDAO.findTrader(offer.getTrader());
        if (id == -1){
            id = traderDAO.save(offer.getTrader());
        }
        offer.getTrader().setId(id);
        int cityId = cityDAO.getCityId(offer.getAddress().getCity().getName());
        offer.getAddress().getCity().setId(cityId);
        int streetId = streetDAO.getStreetId(offer.getAddress().getStreet().getName(),cityId);
        offer.getAddress().getStreet().setId(streetId);
        int idAddress = addressDAO.findAddress(offer.getAddress());
        if (idAddress != -1){
        }

        idAddress = addressDAO.save(offer.getAddress());
        offer.getAddress().setId(idAddress);


        int idFeatures = featuresDAO.save(offer.getFeature());
        offer.getFeature().setId(idFeatures);

        offer.setId(offersDAO.save(offer));

    }

    @Override
    public List<Offer> getAll() {
        return offersDAO.findAll();
    }

    public void delete(Integer id){
        offersDAO.delete(id);
    }

    public void update(Integer id, Integer cost){
        offersDAO.update(id,cost);
    }

}
