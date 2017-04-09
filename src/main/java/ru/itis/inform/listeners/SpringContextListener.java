package ru.itis.inform.listeners;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.inform.config.SpringConfig;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Natalia on 09.03.17.
 */
public class SpringContextListener implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        servletContextEvent.getServletContext().setAttribute("springContext", context);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
