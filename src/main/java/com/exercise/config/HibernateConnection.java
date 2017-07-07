package com.exercise.config;

import java.util.Properties;

import com.exercise.models.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


/**
 * Created by Ibukun.Ogunsolu on 7/2/2017.
 */
public class HibernateConnection {

        private static SessionFactory sessionFactory;

        private static SessionFactory buildSessionFactory() {
            SessionFactory javaSessionFactory = null;
            try {
                Configuration configuration = new Configuration();

                //Create Properties, can be read from property files too
                Properties props = new Properties();
                props.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
                props.put("hibernate.connection.url", "jdbc:mysql://localhost/exercise");
                props.put("hibernate.connection.username", "root");
                props.put("hibernate.connection.password", "");
                props.put("hibernate.current_session_context_class", "thread");

                configuration.setProperties(props);

                configuration.addAnnotatedClass(Application.class);
                configuration.addAnnotatedClass(Contact.class);
                configuration.addAnnotatedClass(Person.class);
                configuration.addAnnotatedClass(Student.class);
                configuration.addAnnotatedClass(Subject.class);
                configuration.addAnnotatedClass(Teacher.class);
                configuration.addAnnotatedClass(StudentSubject.class);
                configuration.addAnnotatedClass(TeacherSubject.class);



                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                javaSessionFactory = configuration.buildSessionFactory(serviceRegistry);

            }
            catch (Throwable ex) {
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
            return javaSessionFactory;
        }

        public static SessionFactory getSessionFactory() {
            if(sessionFactory == null) sessionFactory = buildSessionFactory();
            return sessionFactory;
        }

    }
