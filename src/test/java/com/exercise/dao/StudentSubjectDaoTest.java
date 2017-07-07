package com.exercise.dao;

import com.exercise.config.test.TestConfig;
import com.exercise.models.StudentSubject;
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
public class StudentSubjectDaoTest {

    @Autowired
    StudentSubjectDao studentSubjectDao;

    @After
    public void teardown(){

    }

    private StudentSubject getStudentSubject(){
        StudentSubject studentSubject = new StudentSubject();
        return studentSubject;
    }

    @Test
    public void testCreate() {
        StudentSubject model = getStudentSubject();
        StudentSubject createdModel = studentSubjectDao.create(model);
        assertTrue(createdModel.getId() > 0);
        assertNotNull(createdModel);
    }

    @Test
    public void testUpdate(){
        StudentSubject model = getStudentSubject();
        StudentSubject createdModel = studentSubjectDao.create(model);
        assertTrue(createdModel.getId() > 0);
    }

    @Test
    public void testRead(){
        StudentSubject model = getStudentSubject();
        StudentSubject createdModel = studentSubjectDao.create(model);
        StudentSubject foundModel = studentSubjectDao.get(createdModel.getId());
        assertNotNull(foundModel);
        assertTrue(foundModel.getId() > 0);
    }

    @Test
    public void testDelete(){
        StudentSubject model = getStudentSubject();
        StudentSubject createdModel = studentSubjectDao.create(model);
        StudentSubject foundModel = studentSubjectDao.get(createdModel.getId());
        studentSubjectDao.delete(foundModel.getId());
        StudentSubject foundModel2 = studentSubjectDao.get(createdModel.getId());
        assertNull(foundModel2);
    }

    @Test
    public void testDelete2(){
        StudentSubject model = getStudentSubject();
        StudentSubject createdModel = studentSubjectDao.create(model);
        StudentSubject foundModel = studentSubjectDao.get(createdModel.getId());
        studentSubjectDao.delete(foundModel);
        StudentSubject foundModel2 = studentSubjectDao.get(createdModel.getId());
        assertNull(foundModel2);
    }
}