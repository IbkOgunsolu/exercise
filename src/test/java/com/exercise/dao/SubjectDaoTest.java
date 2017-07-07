package com.exercise.dao;

import com.exercise.config.test.TestConfig;
import com.exercise.models.Subject;
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
public class SubjectDaoTest {

    @Autowired
    SubjectDao subjectDao;

    @After
    public void teardown(){

    }

    private Subject getSubject(){
        Subject subject = new Subject();
        subject.setDescription("physics");
        subject.setCode("PHY001");
        subject.setName("elementary physics");
        return subject;
    }


    @Test
    public void testCreate() {
        Subject model = getSubject();
        Subject createdModel = subjectDao.create(model);
        assertTrue(createdModel.getId() > 0);
        assertNotNull(createdModel);
    }

    @Test
    public void testUpdate(){
        Subject model = getSubject();
        Subject createdModel = subjectDao.create(model);
        createdModel.setDescription("updated physics");
        assertTrue("updated physics".equalsIgnoreCase(createdModel.getDescription()));
        assertTrue(createdModel.getId() > 0);
    }

    @Test
    public void testRead(){
        Subject model = getSubject();
        Subject createdModel = subjectDao.create(model);
        Subject foundModel = subjectDao.get(createdModel.getId());
        assertNotNull(foundModel);
        assertTrue(foundModel.getId() > 0);
    }

    @Test
    public void testDelete(){
        Subject model = getSubject();
        Subject createdModel = subjectDao.create(model);
        Subject foundModel = subjectDao.get(createdModel.getId());
        subjectDao.delete(foundModel.getId());
        Subject foundModel2 = subjectDao.get(createdModel.getId());
        assertNull(foundModel2);
    }

    @Test
    public void testDelete2(){
        Subject model = getSubject();
        Subject createdModel = subjectDao.create(model);
        Subject foundModel = subjectDao.get(createdModel.getId());
        subjectDao.delete(foundModel);
        Subject foundModel2 = subjectDao.get(createdModel.getId());
        assertNull(foundModel2);
    }
}