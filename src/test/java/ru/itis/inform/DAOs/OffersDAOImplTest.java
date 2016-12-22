package ru.itis.inform.DAOs;

import org.junit.Test;
import ru.itis.inform.factories.RieltoryFactory;
import ru.itis.inform.models.rieltoryModel.Offer;
import ru.itis.inform.models.rieltoryModel.OffersTable;

import java.sql.Connection;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Natalia on 06.11.16.
 */
public class OffersDAOImplTest {
    @Test
    public void update() throws Exception {

    }

    @Test
    public void delete() throws Exception {
      Offer offer = new Offer();
        offer.setId(21);
    }

    @Test
    public void getAllOffersWithParams() throws Exception {
        Connection connection = RieltoryFactory.getInstance().getConnection();
        OffersDAO offersDAO = RieltoryFactory.getInstance().getOffersDAO(connection);
        List<Offer> list = offersDAO.getAllOffersWithParams(1, "Удовлетворительное", "Косметический", "Казань",10000,20000);
        for (Offer offer:list) {
            System.out.println(offer);
        }
        assertNotNull(list);


    }

}