package ru.itis.inform.services;

import org.junit.Before;
import org.junit.Test;
import ru.itis.inform.DAOs.OffersDAO;
import ru.itis.inform.models.rieltoryModel.Address;
import ru.itis.inform.models.rieltoryModel.Offer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by Natalia on 06.11.16.
 */
public class OfferceGeneratorServicesImplTest {

    private OffersDAO offersDAO;
    @Before
    public void setUp() throws Exception {
        OffersDAO offersDAO = mock(OffersDAO.class);


        Offer offer = new Offer();
        offer.setCost(14000);
        offer.setId(1);



        List<Offer> offers = new ArrayList<Offer>();

        offers.add(offer);

        when(offersDAO.getAllOffersWithParams(2,"хорошее","есть","Казань",5000,20000)).thenReturn(offers);
        this.offersDAO = offersDAO;
    }

    @Test
    public void generateOfferces() throws Exception {
        OfferseGeneratorService offerseGeneratorService = new OfferceGeneratorServicesImpl(offersDAO);
        List<Offer> offers = offerseGeneratorService.generateOfferces(2,"хорошее","есть","Казань",5000,20000);

        assertEquals(offers.size(),1);

    }

}