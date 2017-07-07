package com.exercise.dao;

import com.exercise.config.HibernateConnection;
import com.exercise.dao.contract.IDao;
import com.exercise.models.Teacher;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Ibukun.Ogunsolu on 7/2/2017.
 */
@Repository
public class TeacherDao implements IDao<Teacher> {

    public Teacher create(Teacher model) {
        Session session = HibernateConnection.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(model);
        session.getTransaction().commit();
        session.close();
        return model;
    }

    public Teacher update(Teacher model) {
        Session session = HibernateConnection.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(model);
        session.getTransaction().commit();
        session.close();
        return model;
    }

    public void delete(Teacher model) {
        Session session = HibernateConnection.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(model);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(int id) {
        Session session = HibernateConnection.getSessionFactory().openSession();
        session.beginTransaction();
        Teacher model = (Teacher) session.get(Teacher.class, id);
        session.delete(model);
        session.getTransaction().commit();
        session.close();
    }

    public Teacher get(int id) {
        Session session = HibernateConnection.getSessionFactory().openSession();
        Teacher model = (Teacher) session.get(Teacher.class, id);
        session.close();
        return model;
    }

    public List<Teacher> getAll() {
        Session session = HibernateConnection.getSessionFactory().openSession();
        List<Teacher> modelList = session.createCriteria(Teacher.class).list();
        session.close();
        return modelList;
    }
}