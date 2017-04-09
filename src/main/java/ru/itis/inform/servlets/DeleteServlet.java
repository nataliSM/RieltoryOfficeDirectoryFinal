package ru.itis.inform.servlets;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.inform.config.SpringConfig;

import ru.itis.inform.models.rieltoryModel.Offer;
import ru.itis.inform.models.rieltoryModel.Street;
import ru.itis.inform.services.OfferseGeneratorService;

import javax.servlet.ServletConfig;
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

    OfferseGeneratorService service;

    public void init (ServletConfig config) throws ServletException {
        super.init(config);
        ApplicationContext context = (ApplicationContext)config.getServletContext().getAttribute("springContext");
        service = context.getBean(OfferseGeneratorService.class);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//
//        request.setCharacterEncoding("utf-8");
//
//        String id = request.getParameter("id");
//        String cost = request.getParameter("cost");
//
//        if(id!=null && cost != null){
//            service.update(Integer.valueOf(id),Integer.valueOf(cost));
//        }
//        else{
//            if (id!=null) {
//                service.delete(Integer.valueOf(id));
//            }
//        }



        List<Offer> offerList= service.getAll();
        request.setAttribute("offers", offerList);
        request.getRequestDispatcher("views/update.jsp").forward(request, response);
    }
}
