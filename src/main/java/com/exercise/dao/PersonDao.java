package com.exercise.dao;

import com.exercise.config.HibernateConnection;
import com.exercise.dao.contract.IDao;
import com.exercise.models.Person;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 * Created by Ibukun.Ogunsolu on 7/2/2017.
 */
@Repository
public class PersonDao implements IDao<Person> {

    public Person create(Person model) {
        Session session = HibernateConnection.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(model);
        session.getTransaction().commit();
        session.close();
        return model;
    }

    public Person update(Person model) {
        Session session = HibernateConnection.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(model);
        session.getTransaction().commit();
        session.close();
        return model;
    }

    public void delete(Person model) {
        Session session = HibernateConnection.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(model);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(int id) {
        Session session = HibernateConnection.getSessionFactory().openSession();
        session.beginTransaction();
        Person model = (Person) session.get(Person.class, id);
        session.delete(model);
        session.getTransaction().commit();
        session.close();
    }

    public Person get(int id) {
        Session session = HibernateConnection.getSessionFactory().openSession();
        Person model = (Person) session.get(Person.class, id);
        session.close();
        return model;
    }
}