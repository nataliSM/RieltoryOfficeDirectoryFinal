package ru.itis.inform.factories;

import ru.itis.inform.DAOs.*;
import ru.itis.inform.services.DataBaseConnectionServices;
import ru.itis.inform.services.DataBaseConnectionServicesImpl;

import java.sql.Connection;

/**
 * Created by Natalia on 05.11.16.
 */
public class RieltoryFactory  {
    private static RieltoryFactory ourInstance = new RieltoryFactory();

    public static RieltoryFactory getInstance() {
        return ourInstance;
    }

    public AddressDAO getAddressDAO(Connection connection){
        return new AddressDAOImpl(connection);
    }

     public CityDAO getCityDAO(Connection connection){
         return new CityDAOImpl(connection);
     }

     public FeaturesDAO getFeaturesDAO(Connection connection){
         return new FeaturesDAOImpl(connection);
     }

     public OffersDAO getOffersDAO(Connection connection){
         return new OffersDAOImpl(connection);
     }

     public StreetDAO getStreetDAO(Connection connection){
         return new StreetDAOImpl(connection);
     }

    public TraderDAO getTraderDAO(Connection connection){
        return new TraderDAOImpl(connection);
    }


    public Connection getConnection(){
        Connection connection;

        DataBaseConnectionServices dataBaseConnectionServices = new DataBaseConnectionServicesImpl();
        connection =  dataBaseConnectionServices.getConnection(Database.RieltoryDatabase);
        return connection;
    }
}
