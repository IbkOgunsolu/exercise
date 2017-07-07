package com.exercise.service;

import com.exercise.dao.TeacherDao;
import com.exercise.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ibukun.Ogunsolu on 7/2/2017.
 */
@Service
public class TeacherService {

    private final TeacherDao teacherDao;

    @Autowired
    public TeacherService(TeacherDao teacherDao){
        this.teacherDao = teacherDao;
    }

    public Teacher create(Teacher model){
        Teacher teacher = null;
        try{
            teacher = teacherDao.create(model);
        }catch(Exception ex){

        }
        return teacher;
    }

    public Teacher get(int id){
        Teacher teacher = null;
        try{
            teacher = teacherDao.get(id);
        }catch(Exception ex){

        }
        return teacher;
    }

    public Teacher update(Teacher model){
        Teacher teacher = null;
        try{
            teacher = teacherDao.update(model);
        }catch(Exception ex){

        }
        return teacher;
    }

    public void delete(Teacher model){
        try{
            teacherDao.delete(model);
        }catch(Exception ex){

        }
    }

    public void delete(int id){
        try{
            teacherDao.delete(id);
        }catch(Exception ex){

        }
    }

    public List<Teacher> getAll(){
        List<Teacher> teachers = null;
        try{
            teachers = teacherDao.getAll();
        }catch(Exception ex){

        }
        return teachers;
    }

}

