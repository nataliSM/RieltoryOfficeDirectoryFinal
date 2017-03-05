package ru.itis.inform.dao.impl.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ru.itis.inform.dao.impl.hibernate.OffersDaoHibernateImpl;
import ru.itis.inform.dao.impl.jdbc.CityDAOImpl;

import javax.sql.DataSource;

/**
 * Created by Natalia on 26.02.17.
 */
@Configuration
@EnableJpaRepositories("ru.itis.inform.dao")
@EnableTransactionManagement
public class TestDaoConfig {
    @Bean
    CityDAOImpl cityDAO() {
        return new CityDAOImpl(dataSource());
    }

    @Bean
    PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory().getObject());
    }

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean =
                new LocalContainerEntityManagerFactoryBean();

        localContainerEntityManagerFactoryBean.setDataSource(dataSource());
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter());
        localContainerEntityManagerFactoryBean.setPackagesToScan("ru.itis.inform.models.rieltoryModel");
        return localContainerEntityManagerFactoryBean;
    }

    @Bean
    HibernateJpaVendorAdapter hibernateJpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setShowSql(true);
        return adapter;
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
