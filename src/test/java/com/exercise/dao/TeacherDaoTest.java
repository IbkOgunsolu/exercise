package com.exercise.dao;

import com.exercise.config.test.TestConfig;
import com.exercise.models.Teacher;
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
public class TeacherDaoTest {

    @Autowired
    TeacherDao teacherDao;

    @After
    public void teardown(){

    }

    private Teacher getTeacher(){
        Teacher teacher = new Teacher();
        teacher.setDesignation("P.Hd.");
        return teacher;
    }


    @Test
    public void testCreate() {
        Teacher model = getTeacher();
        Teacher createdModel = teacherDao.create(model);
        assertTrue(createdModel.getId() > 0);
        assertNotNull(createdModel);
    }

    @Test
    public void testUpdate(){
        Teacher model = getTeacher();
        Teacher createdModel = teacherDao.create(model);
        createdModel.setDesignation("M.Sc");
        assertTrue("M.Sc".equalsIgnoreCase(createdModel.getDesignation()));
        assertTrue(createdModel.getId() > 0);
    }

    @Test
    public void testRead(){
        Teacher model = getTeacher();
        Teacher createdModel = teacherDao.create(model);
        Teacher foundModel = teacherDao.get(createdModel.getId());
        assertNotNull(foundModel);
        assertTrue(foundModel.getId() > 0);
    }

    @Test
    public void testDelete(){
        Teacher model = getTeacher();
        Teacher createdModel = teacherDao.create(model);
        Teacher foundModel = teacherDao.get(createdModel.getId());
        teacherDao.delete(foundModel.getId());
        Teacher foundModel2 = teacherDao.get(createdModel.getId());
        assertNull(foundModel2);
    }

    @Test
    public void testDelete2(){
        Teacher model = getTeacher();
        Teacher createdModel = teacherDao.create(model);
        Teacher foundModel = teacherDao.get(createdModel.getId());
        teacherDao.delete(foundModel);
        Teacher foundModel2 = teacherDao.get(createdModel.getId());
        assertNull(foundModel2);
    }
}