package ru.itis.inform.filters;


import ru.itis.inform.services.VerifyService;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Natalia on 05.11.16.
 */
public class HomeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        Cookie[] cookies = request.getCookies();
//        VerifyService verifyService = ServiceFactory.getInstance().getVerifyService();
//        boolean logined = verifyService.isClientLogined(cookies);
//        if (!logined) {
//            response.sendRedirect("/login");
//            return;
//        }
//        filterChain.doFilter(request, response);

    }

    @Override
    public void destroy() {

    }
}
