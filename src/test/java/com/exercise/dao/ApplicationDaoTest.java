package com.exercise.dao;

import com.exercise.config.test.TestConfig;
import com.exercise.models.Application;
import com.exercise.models.ApplicationStatus;
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
public class ApplicationDaoTest {

    @Autowired
    ApplicationDao applicationDao;

    @After
    public void teardown(){

    }

    private Application getApplication(){
        Application application = new Application();
        application.setStatementOfPurpose("I am a great student");
        application.setStatus(ApplicationStatus.PENDING);
        return application;
    }


    @Test
    public void testCreate() {
        Application model = getApplication();
        Application createdModel = applicationDao.create(model);
        assertTrue(createdModel.getId() > 0);
        assertNotNull(createdModel);
    }

    @Test
    public void testUpdate(){
        Application model = getApplication();
        Application createdModel = applicationDao.create(model);
        createdModel.setStatementOfPurpose("update statement of purpose");
        assertTrue("update statement of purpose".equalsIgnoreCase(createdModel.getStatementOfPurpose()));
        assertTrue(createdModel.getId() > 0);
    }

    @Test
    public void testRead(){
        Application model = getApplication();
        Application createdModel = applicationDao.create(model);
        Application foundModel = applicationDao.get(createdModel.getId());
        assertNotNull(foundModel);
        assertTrue(foundModel.getId() > 0);
    }

    @Test
    public void testDelete(){
        Application model = getApplication();
        Application createdModel = applicationDao.create(model);
        Application foundModel = applicationDao.get(createdModel.getId());
        applicationDao.delete(foundModel.getId());
        Application foundModel2 = applicationDao.get(createdModel.getId());
        assertNull(foundModel2);
    }

    @Test
    public void testDelete2(){
        Application model = getApplication();
        Application createdModel = applicationDao.create(model);
        Application foundModel = applicationDao.get(createdModel.getId());
        applicationDao.delete(foundModel);
        Application foundModel2 = applicationDao.get(createdModel.getId());
        assertNull(foundModel2);
    }
}