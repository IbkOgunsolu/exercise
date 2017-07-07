package com.exercise.dao;

import com.exercise.config.test.TestConfig;
import com.exercise.dao.ContactDao;
import com.exercise.models.Contact;
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
public class ContactDaoTest {

    @Autowired
    ContactDao contactDao;

    @After
    public void teardown(){

    }

    private Contact getContact(){
        Contact contact = new Contact();
        contact.setAddressLine1("2, adio street");
        contact.setAddressLine2("lekki");
        contact.setCity("lekki");
        contact.setState("lagos");
        contact.setCountry("nigeria");
        return contact;
    }


    @Test
    public void testCreate() {
        Contact model = getContact();
        Contact createdModel = contactDao.create(model);
        assertTrue(createdModel.getId() > 0);
        assertNotNull(createdModel);
    }

    @Test
    public void testUpdate(){
        Contact model = getContact();
        Contact createdModel = contactDao.create(model);
        createdModel.setCountry("Ghana");
        assertTrue("Ghana".equalsIgnoreCase(createdModel.getCountry()));
        assertTrue(createdModel.getId() > 0);
    }

    @Test
    public void testRead(){
        Contact model = getContact();
        Contact createdModel = contactDao.create(model);
        Contact foundModel = contactDao.get(createdModel.getId());
        assertNotNull(foundModel);
        assertTrue(foundModel.getId() > 0);
    }

    @Test
    public void testDelete(){
        Contact model = getContact();
        Contact createdModel = contactDao.create(model);
        Contact foundModel = contactDao.get(createdModel.getId());
        contactDao.delete(foundModel.getId());
        Contact foundModel2 = contactDao.get(createdModel.getId());
        assertNull(foundModel2);
    }

    @Test
    public void testDelete2(){
        Contact model = getContact();
        Contact createdModel = contactDao.create(model);
        Contact foundModel = contactDao.get(createdModel.getId());
        contactDao.delete(foundModel);
        Contact foundModel2 = contactDao.get(createdModel.getId());
        assertNull(foundModel2);
    }
}