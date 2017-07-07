package com.exercise.dao;

import com.exercise.config.HibernateConnection;
import com.exercise.dao.contract.IDao;
import com.exercise.models.Student;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Ibukun.Ogunsolu on 7/2/2017.
 */
@Repository
public class StudentDao implements IDao<Student> {

    public Student create(Student model) {
        Session session = HibernateConnection.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(model);
        session.getTransaction().commit();
        session.close();
        return model;
    }

    public Student update(Student model) {
        Session session = HibernateConnection.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(model);
        session.getTransaction().commit();
        session.close();
        return model;
    }

    public void delete(Student model) {
        Session session = HibernateConnection.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(model);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(int id) {
        Session session = HibernateConnection.getSessionFactory().openSession();
        session.beginTransaction();
        Student model = (Student) session.get(Student.class, id);
        session.delete(model);
        session.getTransaction().commit();
        session.close();
    }

    public Student get(int id) {
        Session session = HibernateConnection.getSessionFactory().openSession();
        Student model = (Student) session.get(Student.class, id);
        session.close();
        return model;
    }

    public List<Student> getAll() {
        Session session = HibernateConnection.getSessionFactory().openSession();
        List<Student> modelList = session.createCriteria(Student.class).list();
        session.close();
        return modelList;
    }
}