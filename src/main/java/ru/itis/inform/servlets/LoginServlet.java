package ru.itis.inform.servlets;

import ru.itis.inform.factories.ServiceFactory;
import ru.itis.inform.services.VerifyService;
import ru.itis.inform.models.User;
import ru.itis.inform.services.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Created by Natalia on 09.10.16.
 */

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username,password);
        LoginService loginService = ServiceFactory.getInstance().getLoginService();

        if (loginService.verifyUser(username, password)) {

            ArrayList<Cookie> cookies = loginService.getCookies();
            if(cookies != null) {
                for (Cookie cookie : cookies) {
                    response.addCookie(cookie);
                }
            }
            response.sendRedirect("/home");
        }
        else {
            request.setAttribute("error", "Unknown user, please try again");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
