package ru.itis.inform.services;

import ru.itis.inform.DAOs.*;
import ru.itis.inform.factories.RieltoryFactory;
import ru.itis.inform.models.rieltoryModel.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Natalia on 05.11.16.
 */
public class OfferceGeneratorServicesImpl implements OfferseGeneratorService{
private OffersDAO offersDAO;

    public OfferceGeneratorServicesImpl() {
    }

    public OfferceGeneratorServicesImpl(OffersDAO offersDAO) {
        this.offersDAO = offersDAO;
    }

    public List<Offer> generateOfferces(int numberOfRooms, String condition, String repair, String cityName, Integer startCost, Integer endCost)
    {
        OffersDAO offersDAO;

        if (this.offersDAO != null){
            offersDAO = this.offersDAO;
        }
        else{
            Connection connection = RieltoryFactory.getInstance().getConnection();
             offersDAO = RieltoryFactory.getInstance().getOffersDAO(connection);
        }

        return offersDAO.getAllOffersWithParams(numberOfRooms, condition, repair, cityName,startCost,endCost);
    }



    @Override
    public List<City> getAllCities() {
        Connection connection = RieltoryFactory.getInstance().getConnection();
        CityDAO dao = RieltoryFactory.getInstance().getCityDAO(connection);

        return dao.getAll();
    }

    @Override
    public List<Street> getAllStreets() {
        Connection connection = RieltoryFactory.getInstance().getConnection();
        StreetDAO dao = RieltoryFactory.getInstance().getStreetDAO(connection);

        return dao.getAll();
    }

    @Override
    public void save(Offer offer) {
        Connection connection = RieltoryFactory.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        TraderDAO traderDAO = RieltoryFactory.getInstance().getTraderDAO(connection);
        AddressDAO addressDAO = RieltoryFactory.getInstance().getAddressDAO(connection);
        FeaturesDAO featuresDAO = RieltoryFactory.getInstance().getFeaturesDAO(connection);
        OffersDAO offersDAO = RieltoryFactory.getInstance().getOffersDAO(connection);
        CityDAO cityDAO = RieltoryFactory.getInstance().getCityDAO(connection);
        StreetDAO streetDAO = RieltoryFactory.getInstance().getStreetDAO(connection);

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

        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Offer> getAll() {
        Connection connection = RieltoryFactory.getInstance().getConnection();
        offersDAO = RieltoryFactory.getInstance().getOffersDAO(connection);
        return offersDAO.getAll();
    }

    public void delete(Integer id){
        Connection connection = RieltoryFactory.getInstance().getConnection();
        offersDAO = RieltoryFactory.getInstance().getOffersDAO(connection);
        offersDAO.delete(id);
    }

    public void update(Integer id, Integer cost){
        Connection connection = RieltoryFactory.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        OffersDAO offersDAO = RieltoryFactory.getInstance().getOffersDAO(connection);
        offersDAO.update(id,cost);

        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
