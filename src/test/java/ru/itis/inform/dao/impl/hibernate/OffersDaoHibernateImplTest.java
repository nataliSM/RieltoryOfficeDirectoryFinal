package ru.itis.inform.dao.impl.hibernate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.itis.inform.dao.impl.config.TestDaoConfig;
import ru.itis.inform.models.*;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Natalia on 25.02.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDaoConfig.class)
public class OffersDaoHibernateImplTest {
    @Autowired
    OffersDaoHibernateImpl offersDaoHibernate;

    @Test
    public void update() throws Exception {
        Offer offer = new Offer();
        offer.setId(1);
        offer.setCost(123);
        offersDaoHibernate.update(offer);

    }

    @Test
    public void find() throws Exception {
       Offer offer = offersDaoHibernate.find(2);
        assertTrue(offer.getCost() == 100000);
    }

    @Test
    public void delete() throws Exception {
        offersDaoHibernate.delete(2);
    }

    @Test
    public void findAll() throws Exception {
       List<Offer> offerList =  offersDaoHibernate.findAll();
        assertTrue(offerList.size() == 7);
    }



    @Test
    public void save() throws Exception {
        Offer offer = new Offer();
        offer.setCost(1000);
        Address address = new Address();
        City city = new City();
        city.setName("KKKM");
        Street street = new Street();
        street.setName("MMM");
        street.setCity(city);
        address.setCity(city);
        address.setStreet(street);
        address.setHouse(13);
        address.setFlat(2);
        offer.setAddress(address);

        offer.setAddress(address);

        Trader trader = new Trader();
        trader.setName("Х");
        trader.setPhoneNumber("12345678908");

        Feature feature = new Feature();
        feature.setCondition("asd");
        feature.setCountOfRoom(2);
        feature.setRepair("das");

        offer.setFeature(feature);

        offer.setTrader(trader);
        offersDaoHibernate.save(offer);

        System.out.print(offer);
        assertTrue(offer.getId() > 0);
    }

    @Test
    public void getAllOffersWithParams() throws Exception {
        List<Offer> offerList = offersDaoHibernate.getAllOffersWithParams(2, "sad", "asd", "asd", 1, 2);
        System.out.print(offerList);

    }

    @Test
    public void testUpdateWithCostAndId() throws  Exception {

       offersDaoHibernate.update(2, 22);

    }


}