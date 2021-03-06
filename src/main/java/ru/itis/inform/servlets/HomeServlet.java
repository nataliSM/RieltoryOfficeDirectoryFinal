package ru.itis.inform.servlets;

import ru.itis.inform.factories.ServiceFactory;
import ru.itis.inform.models.rieltoryModel.City;
import ru.itis.inform.models.rieltoryModel.Offer;
import ru.itis.inform.services.OfferseGeneratorService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Natalia on 05.11.16.
 */
public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        OfferseGeneratorService offerseGeneratorService = ServiceFactory.getInstance().getOfferseGeneratorService();
        String numberOfRooms = request.getParameter("numberOfRooms");
        String condition = request.getParameter("condition");
        String repair = request.getParameter("repair");
        String city = request.getParameter("city");
        String startCost = request.getParameter("startCost");
        String endCost = request.getParameter("endCost");
        List<Offer> offerList = null;
        try {
          offerList = offerseGeneratorService.generateOfferces(Integer.valueOf(numberOfRooms), condition, repair, city, Integer.valueOf(startCost), Integer.valueOf(endCost));
        }catch ( NumberFormatException e){
            response.sendError(403);
            return;
        }
        request.setAttribute("offerList", offerList);

        List<City> cityList = offerseGeneratorService.getAllCities();
        request.setAttribute("cityList", cityList);

        request.getRequestDispatcher("/home.jsp").forward(request, response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        OfferseGeneratorService offerseGeneratorService = ServiceFactory.getInstance().getOfferseGeneratorService();
        List<City> cityList = offerseGeneratorService.getAllCities();
        request.setAttribute("cityList", cityList);
        request.getRequestDispatcher("/home.jsp").forward(request, response);
    }
}
