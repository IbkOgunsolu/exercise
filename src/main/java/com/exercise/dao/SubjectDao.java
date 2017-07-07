package com.exercise.dao;

import com.exercise.config.HibernateConnection;
import com.exercise.dao.contract.IDao;
import com.exercise.models.Subject;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Ibukun.Ogunsolu on 7/2/2017.
 */
@Repository
public class SubjectDao implements IDao<Subject> {

    public Subject create(Subject model) {
        Session session = HibernateConnection.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(model);
        session.getTransaction().commit();
        session.close();
        return model;
    }

    public Subject update(Subject model) {
        Session session = HibernateConnection.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(model);
        session.getTransaction().commit();
        session.close();
        return model;
    }

    public void delete(Subject model) {
        Session session = HibernateConnection.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(model);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(int id) {
        Session session = HibernateConnection.getSessionFactory().openSession();
        session.beginTransaction();
        Subject model = (Subject) session.get(Subject.class, id);
        session.delete(model);
        session.getTransaction().commit();
        session.close();
    }

    public Subject get(int id) {
        Session session = HibernateConnection.getSessionFactory().openSession();
        Subject model = (Subject) session.get(Subject.class, id);
        session.close();
        return model;
    }

    public List<Subject> getAll() {
        Session session = HibernateConnection.getSessionFactory().openSession();
        List<Subject> modelList = session.createCriteria(Subject.class).list();
        session.close();
        return modelList;
    }

}