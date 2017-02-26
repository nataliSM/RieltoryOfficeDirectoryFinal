package ru.itis.inform.servlets;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.inform.config.SpringConfig;
import ru.itis.inform.models.rieltoryModel.*;
import ru.itis.inform.services.OfferseGeneratorService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Set;

/**
 * Created by Natalia on 18.12.16.
 */
public class NewPostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Set set = request.getParameterMap().entrySet();
        String countOfRooms = request.getParameter("numberOfRooms");
        String repair = request.getParameter("repair");
        String condition = request.getParameter("condition");
        String city = request.getParameter("city");
        String street = request.getParameter("street");
        String house = request.getParameter("house");
        String flat = request.getParameter("flat");
        String cost = request.getParameter("cost");
        String traderName = request.getParameter("traderName");
        String traderPhone = request.getParameter("traderPhone");

        Offer offer = new Offer();

        Trader trader = new Trader();
        trader.setName(traderName);
        trader.setPhoneNumber(traderPhone);

        Feature feature = new Feature();
        feature.setRepair(repair);
        feature.setCondition(condition);
        Address address = new Address();


        try{
            feature.setCountOfRoom(Integer.valueOf(countOfRooms));
            offer.setCost(Integer.valueOf(cost));
            address.setHouse(Integer.valueOf(house));
            address.setFlat(Integer.valueOf(flat));

        }catch (Exception e)
        {
            response.sendError(403, "Wrong fields");
            return;
        }
        City city1 = new City();
        city1.setName(city);
        Street street1 = new Street();
        street1.setName(street);
        street1.setCity(city1);

        address.setCity(city1);
        address.setStreet(street1);

        offer.setAddress(address);
        offer.setFeature(feature);
        offer.setTrader(trader);

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        OfferseGeneratorService offerseGeneratorService = context.getBean(OfferseGeneratorService.class);
        offerseGeneratorService.save(offer);
        response.sendRedirect("/home");




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        OfferseGeneratorService offerseGeneratorService = context.getBean(OfferseGeneratorService.class);
        List<City> cityList = offerseGeneratorService.getAllCities();
        List<Street> streetList = offerseGeneratorService.getAllStreets();
        request.setAttribute("cityList", cityList);
        request.setAttribute("streetList", streetList);

        request.getRequestDispatcher("/newPost.jsp").forward(request, response);
    }
    }
