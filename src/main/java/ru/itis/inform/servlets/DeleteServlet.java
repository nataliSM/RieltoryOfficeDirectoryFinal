package ru.itis.inform.servlets;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.inform.config.SpringConfig;

import ru.itis.inform.models.rieltoryModel.Offer;
import ru.itis.inform.models.rieltoryModel.Street;
import ru.itis.inform.services.OfferseGeneratorService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Natalia on 19.12.16.
 */
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        OfferseGeneratorService offerseGeneratorService = context.getBean(OfferseGeneratorService.class);
        request.setCharacterEncoding("utf-8");

        String id = request.getParameter("id");
        String cost = request.getParameter("cost");

        if(id!=null && cost != null){
            offerseGeneratorService.update(Integer.valueOf(id),Integer.valueOf(cost));
        }
        else{
            if (id!=null) {
                offerseGeneratorService.delete(Integer.valueOf(id));
            }
        }



        List<Offer> offerList= offerseGeneratorService.getAll();
        request.setAttribute("offerList", offerList);
        request.getRequestDispatcher("/delete.jsp").forward(request, response);
    }
}
