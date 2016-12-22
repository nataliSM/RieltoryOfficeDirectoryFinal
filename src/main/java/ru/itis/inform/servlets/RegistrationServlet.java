package ru.itis.inform.servlets;

import ru.itis.inform.factories.ServiceFactory;
import ru.itis.inform.services.RegistrationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Natalia on 10.10.16.
 */
public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        RegistrationService registrationService = ServiceFactory.getInstance().getRegistrationService();
        registrationService.registrateUser(username,password);
        request.getRequestDispatcher("/login.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/registration.jsp").forward(request, response);
    }
}
