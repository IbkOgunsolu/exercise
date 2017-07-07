package com.exercise.dao;

import com.exercise.config.test.TestConfig;
import com.exercise.models.TeacherSubject;
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
public class TeacherSubjectDaoTest {

    @Autowired
    TeacherSubjectDao teacherSubjectDao;

    @After
    public void teardown(){

    }

    private TeacherSubject getTeacherSubject(){
        TeacherSubject teacherSubject = new TeacherSubject();
        return teacherSubject;
    }


    @Test
    public void testCreate() {
        TeacherSubject model = getTeacherSubject();
        TeacherSubject createdModel = teacherSubjectDao.create(model);
        assertTrue(createdModel.getId() > 0);
        assertNotNull(createdModel);
    }

    @Test
    public void testUpdate(){
        TeacherSubject model = getTeacherSubject();
        TeacherSubject createdModel = teacherSubjectDao.create(model);
        assertTrue(createdModel.getId() > 0);
    }

    @Test
    public void testRead(){
        TeacherSubject model = getTeacherSubject();
        TeacherSubject createdModel = teacherSubjectDao.create(model);
        TeacherSubject foundModel = teacherSubjectDao.get(createdModel.getId());
        assertNotNull(foundModel);
        assertTrue(foundModel.getId() > 0);
    }

    @Test
    public void testDelete(){
        TeacherSubject model = getTeacherSubject();
        TeacherSubject createdModel = teacherSubjectDao.create(model);
        TeacherSubject foundModel = teacherSubjectDao.get(createdModel.getId());
        teacherSubjectDao.delete(foundModel.getId());
        TeacherSubject foundModel2 = teacherSubjectDao.get(createdModel.getId());
        assertNull(foundModel2);
    }

    @Test
    public void testDelete2(){
        TeacherSubject model = getTeacherSubject();
        TeacherSubject createdModel = teacherSubjectDao.create(model);
        TeacherSubject foundModel = teacherSubjectDao.get(createdModel.getId());
        teacherSubjectDao.delete(foundModel);
        TeacherSubject foundModel2 = teacherSubjectDao.get(createdModel.getId());
        assertNull(foundModel2);
    }
}