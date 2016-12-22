package ru.itis.inform.factories;

import ru.itis.inform.DAOs.Database;
import ru.itis.inform.services.*;

/**
 * Created by Natalia on 09.10.16.
 */
public class ServiceFactory {
    private static ServiceFactory ourInstance = new ServiceFactory();

    public static ServiceFactory getInstance() {

        return ourInstance;
    }

    public LoginService getLoginService ()
    {
        return new LoginServiceImpl();

    }    private ServiceFactory() {
    }

    public DataBaseConnectionServices getDataBaseConnectionServices(){

        return new DataBaseConnectionServicesImpl();
    }

    public RegistrationService getRegistrationService(){
        return new RegistrationServiceImpl();
    }

    public VerifyService getVerifyService(){
        return  new VerifyServiceImpl();
    }

    public OfferseGeneratorService getOfferseGeneratorService ()
    {
        return new OfferceGeneratorServicesImpl();
    }
}

