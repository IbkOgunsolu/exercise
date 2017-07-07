package com.exercise.dao;

import com.exercise.config.HibernateConnection;
import com.exercise.dao.contract.IDao;
import com.exercise.models.StudentSubject;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 * Created by Ibukun.Ogunsolu on 7/2/2017.
 */
@Repository
public class StudentSubjectDao implements IDao<StudentSubject> {

    public StudentSubject create(StudentSubject model) {
        Session session = HibernateConnection.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(model);
        session.getTransaction().commit();
        session.close();
        return model;
    }

    public StudentSubject update(StudentSubject model) {
        Session session = HibernateConnection.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(model);
        session.getTransaction().commit();
        session.close();
        return model;
    }

    public void delete(StudentSubject model) {
        Session session = HibernateConnection.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(model);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(int id) {
        Session session = HibernateConnection.getSessionFactory().openSession();
        session.beginTransaction();
        StudentSubject model = (StudentSubject) session.get(StudentSubject.class, id);
        session.delete(model);
        session.getTransaction().commit();
        session.close();
    }

    public StudentSubject get(int id) {
        Session session = HibernateConnection.getSessionFactory().openSession();
        StudentSubject model = (StudentSubject) session.get(StudentSubject.class, id);
        session.close();
        return model;
    }
}