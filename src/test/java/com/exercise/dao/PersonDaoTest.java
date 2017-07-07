package com.exercise.dao;

import com.exercise.config.test.TestConfig;
import com.exercise.models.Contact;
import com.exercise.models.Person;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Ibukun.Ogunsolu on 7/2/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(locations = {"classpath:test.properties"})
@ContextConfiguration(classes = {TestConfig.class})
public class PersonDaoTest {

    @Autowired
    PersonDao personDao;

    @After
    public void teardown(){

    }

    private Person getPerson(){
        Person person = new Person();
        person.setFirstName("Elixa");
        person.setSurname("Pearl");
        person.setOtherNames("do-joie");
        return person;
    }


    @Test
    public void testCreate() {
        Person model = getPerson();
        Person createdModel = personDao.create(model);
        assertTrue(createdModel.getId() > 0);
        assertNotNull(createdModel);
        personDao.delete(model);
    }

    @Test
    public void testUpdate(){
        Person model = getPerson();
        Person createdModel = personDao.create(model);
        createdModel.setFirstName("gell");
        assertTrue("gell".equalsIgnoreCase(createdModel.getFirstName()));
        assertTrue(createdModel.getId() > 0);
        personDao.delete(model);
    }

    @Test
    public void testRead(){
        Person model = getPerson();
        Person createdModel = personDao.create(model);
        Person foundModel = personDao.get(createdModel.getId());
        assertNotNull(foundModel);
        assertTrue(foundModel.getId() > 0);
        personDao.delete(model);
    }

    @Test
    public void testDelete(){
        Person model = getPerson();
        Person createdModel = personDao.create(model);
        Person foundModel = personDao.get(createdModel.getId());
        personDao.delete(foundModel.getId());
        Person foundModel2 = personDao.get(createdModel.getId());
        assertNull(foundModel2);
    }

    @Test
    public void testDelete2(){
        Person model = getPerson();
        Person createdModel = personDao.create(model);
        Person foundModel = personDao.get(createdModel.getId());
        personDao.delete(foundModel);
        Person foundModel2 = personDao.get(createdModel.getId());
        assertNull(foundModel2);
    }
}