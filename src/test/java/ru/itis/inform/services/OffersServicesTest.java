package ru.itis.inform.services;

import org.junit.Test;
import ru.itis.inform.models.rieltoryModel.*;

import static org.junit.Assert.*;

/**
 * Created by Natalia on 18.12.16.
 */
public class OffersServicesTest {
    @Test
    public void addNewOffer() throws Exception {

        Offer offer =  new Offer();
        offer.setCost(12000);
        Trader trader = new Trader();
        trader.setName("NataLia");
        trader.setPhoneNumber("89600446630");
        offer.setTrader(trader);
        Feature feature = new Feature();
        feature.setCondition("good");
        feature.setCountOfRoom(3);
        feature.setRepair("yes");
        offer.setFeature(feature);

        Address address = new Address();
        City city =new City();
        city.setId(1);
        city.setName("Казань");
        Street street = new Street();
        street.setId(1);
        street.setName("Завойского");
        street.setCity(city);
        address.setCity(city);
        address.setStreet(street);
        address.setHouse(24);
        address.setFlat(1);

        offer.setAddress(address);

        OffersServices offersServices = new OffersServices();
        offersServices.addNewOffer(offer);




    }

}