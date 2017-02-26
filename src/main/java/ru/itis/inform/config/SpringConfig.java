package ru.itis.inform.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

import javax.sql.DataSource;

@Configuration
@ComponentScan("ru.itis.inform")
@PropertySource("ru.itis.inform/db.properties")
public class SpringConfig {

    @Autowired
    Environment environment;

    @Bean
    public SessionFactory sessionFactory() {
        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource());
        builder.addResource("ru.itis.inform/hibernate/Address.hbm.xml");
        builder.addResource("ru.itis.inform/hibernate/City.hbm.xml");
        builder.addResource("ru.itis.inform/hibernate/Offers.hbm.xml");
        builder.addResource("ru.itis.inform/hibernate/Street.hbm.xml");
        builder.addResource("ru.itis.inform/hibernate/Trader.hbm.xml");
        builder.addResource("ru.itis.inform/hibernate/Feature.hbm.xml");
        builder.setProperty("hibernate.dialect","org.hibernate.dialect.PostgreSQL82Dialect");
        return builder.buildSessionFactory();
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("RieltoryDatabase.driver"));
        dataSource.setUrl(environment.getProperty("RieltoryDatabase.urlString"));
        dataSource.setUsername(environment.getProperty("RieltoryDatabase.user"));
        dataSource.setPassword(environment.getProperty("RieltoryDatabase.password"));

        return dataSource;
    }
}
