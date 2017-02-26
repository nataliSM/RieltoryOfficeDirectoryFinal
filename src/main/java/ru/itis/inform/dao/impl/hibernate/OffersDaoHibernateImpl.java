package ru.itis.inform.dao.impl.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.inform.dao.OffersDAO;
import ru.itis.inform.models.rieltoryModel.Offer;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Natalia on 25.02.17.
 */
@Component("hibernate.offers.dao")
public class OffersDaoHibernateImpl implements OffersDAO {



    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Offer> getAllOffersWithParams(int countOfRoom,
                                              String condition,
                                              String repair,
                                              String cityName,
                                              Integer startCost,
                                              Integer endCost) {
        Session session = getSession();
        session.beginTransaction();
        Query query = session.createQuery("from Offer as offer join offer.feature as feature where feature.countOfRoom = :countOfRoom");
        query.setParameter("countOfRoom", countOfRoom);
//        query.setParameter("repair", repair);
//        query.setParameter("condition", condition);
//        query.setParameter("cityName", cityName);
        return query.list();
    }

    @Override
    public Integer save(Offer offer) {

        Session currentSession = getSession();
         Transaction tx = null;
        try {
            tx =currentSession.beginTransaction();
            currentSession.save(offer);
            tx.commit();
        }
        catch (HibernateException e) {
            tx.rollback();
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.toString());
        }


          return offer.getId();
    }

    @Override
    public void update(Integer id, Integer cost) {
        Session currentSession = getSession();
        currentSession.beginTransaction();
        Offer offer =  currentSession.load(Offer.class, id);
        offer.setCost(cost);
        currentSession.flush();

    }

    @Override
    public void update(Offer offer) {
        Session currentSession = getSession();
        Transaction tx = null;
        try {
            tx =currentSession.beginTransaction();
            currentSession.update(offer);
            tx.commit();
        }
        catch (RuntimeException e) {
            tx.rollback();
            Logger.getLogger(getClass().getName()).log(Level.INFO, e.toString());
        }
    }

    @Override
    public Offer find(Integer id) {
        Session session = getSession();
        Transaction tx = null;
        Offer offer = null;
        try{
            tx = session.beginTransaction();
            offer = session.get(Offer.class, id);
            tx.commit();
        }
        catch (RuntimeException e) {
            tx.rollback();
            Logger.getLogger(getClass().getName()).log(Level.INFO, e.toString());
        }
        return offer;
    }

    @Override
    public void delete(Integer id) {

        Session seccion = sessionFactory.getCurrentSession();
        seccion.beginTransaction();
        Offer offer = seccion.load(Offer.class, id);
        seccion.delete(offer);
        seccion.flush();
    }

    @Override
    public List<Offer> findAll() {
        Session currentSession = getSession();
        currentSession.beginTransaction();
        List<Offer> offerList = currentSession.createQuery("from " + Offer.class.getName()).list();
        return offerList;
    }


    private Session getSession() {
        Session session;

        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }

        return session;
    }
}
