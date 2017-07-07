package com.exercise.dao;

import com.exercise.config.HibernateConnection;
import com.exercise.dao.contract.IDao;
import com.exercise.models.Contact;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 * Created by Ibukun.Ogunsolu on 7/2/2017.
 */
@Repository
public class ContactDao implements IDao<Contact> {

    public Contact create(Contact model){
        Session session = HibernateConnection.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(model);
        session.getTransaction().commit();
        session.close();
        return model;
    }

    public Contact update(Contact model){
        Session session = HibernateConnection.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(model);
        session.getTransaction().commit();
        session.close();
        return model;
    }

    public void delete(Contact model){
        Session session = HibernateConnection.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(model);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(int id){
        Session session = HibernateConnection.getSessionFactory().openSession();
        session.beginTransaction();
        Contact model =  (Contact)session.get(Contact.class, id);
        session.delete(model);
        session.getTransaction().commit();
        session.close();
    }

    public Contact get(int id){
        Session session = HibernateConnection.getSessionFactory().openSession();
        Contact model =  (Contact)session.get(Contact.class, id);
        session.close();
        return model;
    }

}
