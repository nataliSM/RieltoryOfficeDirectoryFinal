package ru.itis.inform.dao.impl.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import ru.itis.inform.dao.impl.hibernate.OffersDaoHibernateImpl;
import ru.itis.inform.dao.impl.jdbc.CityDAOImpl;

import javax.sql.DataSource;

/**
 * Created by Natalia on 26.02.17.
 */
@Configuration
public class TestDaoConfig {
    @Bean
    CityDAOImpl cityDAO() {
        return new CityDAOImpl(dataSource());
    }

    @Bean
    public SessionFactory sessionFactory() {
        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource());
        builder.addResource("ru.itis.inform/hibernate/Address.hbm.xml");
        builder.addResource("ru.itis.inform/hibernate/City.hbm.xml");
        builder.addResource("ru.itis.inform/hibernate/Offers.hbm.xml");
        builder.addResource("ru.itis.inform/hibernate/Street.hbm.xml");
        builder.addResource("ru.itis.inform/hibernate/Trader.hbm.xml");
        builder.addResource("ru.itis.inform/hibernate/Feature.hbm.xml");
        builder.setProperty("hibernate.dialect","org.hibernate.dialect.H2Dialect");
        return builder.buildSessionFactory();
    }

    @Bean
    OffersDaoHibernateImpl offersDaoHibernate(){return new OffersDaoHibernateImpl();}


    @Bean
    DataSource dataSource() {
        EmbeddedDatabase database =
                new EmbeddedDatabaseBuilder()
                        .setType(EmbeddedDatabaseType.H2)
                        .addScript("scripts/schema.sql")
                        .addScript("scripts/data.sql")
                        .build();
        return database;
    }
}
