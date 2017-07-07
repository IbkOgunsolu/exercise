package com.exercise.dao;

import com.exercise.config.HibernateConnection;
import com.exercise.dao.contract.IDao;
import com.exercise.models.TeacherSubject;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 * Created by Ibukun.Ogunsolu on 7/2/2017.
 */
@Repository
public class TeacherSubjectDao implements IDao<TeacherSubject> {

    public TeacherSubject create(TeacherSubject model) {
        Session session = HibernateConnection.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(model);
        session.getTransaction().commit();
        session.close();
        return model;
    }

    public TeacherSubject update(TeacherSubject model) {
        Session session = HibernateConnection.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(model);
        session.getTransaction().commit();
        session.close();
        return model;
    }

    public void delete(TeacherSubject model) {
        Session session = HibernateConnection.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(model);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(int id) {
        Session session = HibernateConnection.getSessionFactory().openSession();
        session.beginTransaction();
        TeacherSubject model = (TeacherSubject) session.get(TeacherSubject.class, id);
        session.delete(model);
        session.getTransaction().commit();
        session.close();
    }

    public TeacherSubject get(int id) {
        Session session = HibernateConnection.getSessionFactory().openSession();
        TeacherSubject model = (TeacherSubject) session.get(TeacherSubject.class, id);
        session.close();
        return model;
    }
}
