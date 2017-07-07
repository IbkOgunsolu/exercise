package com.exercise.dao;

import com.exercise.config.test.TestConfig;
import com.exercise.models.Student;
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
public class StudentDaoTest {

    @Autowired
    StudentDao studentDao;

    @After
    public void teardown(){

    }

    private Student getStudent(){
        Student student = new Student();
        student.setDiscipline("science");
        return student;
    }

    @Test
    public void testCreate() {
        Student model = getStudent();
        Student createdModel = studentDao.create(model);
        assertTrue(createdModel.getId() > 0);
        assertNotNull(createdModel);
    }

    @Test
    public void testUpdate(){
        Student model = getStudent();
        Student createdModel = studentDao.create(model);
        createdModel.setDiscipline("arts");
        assertTrue("arts".equalsIgnoreCase(createdModel.getDiscipline()));
        assertTrue(createdModel.getId() > 0);
    }

    @Test
    public void testRead(){
        Student model = getStudent();
        Student createdModel = studentDao.create(model);
        Student foundModel = studentDao.get(createdModel.getId());
        assertNotNull(foundModel);
        assertTrue(foundModel.getId() > 0);
    }

    @Test
    public void testDelete(){
        Student model = getStudent();
        Student createdModel = studentDao.create(model);
        Student foundModel = studentDao.get(createdModel.getId());
        studentDao.delete(foundModel.getId());
        Student foundModel2 = studentDao.get(createdModel.getId());
        assertNull(foundModel2);
    }

    @Test
    public void testDelete2(){
        Student model = getStudent();
        Student createdModel = studentDao.create(model);
        Student foundModel = studentDao.get(createdModel.getId());
        studentDao.delete(foundModel);
        Student foundModel2 = studentDao.get(createdModel.getId());
        assertNull(foundModel2);
    }
}