package com.exercise.service;

import com.exercise.dao.StudentDao;
import com.exercise.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ibukun.Ogunsolu on 7/2/2017.
 */
@Service
public class StudentService {

    private final StudentDao studentDao;

    @Autowired
    public StudentService(StudentDao studentDao){
        this.studentDao = studentDao;
    }

    public Student create(Student model){
        Student student = null;
        try{
            student = studentDao.create(model);
        }catch(Exception ex){

        }
        return student;
    }

    public Student get(int id){
        Student student = null;
        try{
            student = studentDao.get(id);
        }catch(Exception ex){

        }
        return student;
    }

    public Student update(Student model){
        Student student = null;
        try{
            student = studentDao.update(model);
        }catch(Exception ex){

        }
        return student;
    }

    public void delete(Student model){
        try{
            studentDao.delete(model);
        }catch(Exception ex){

        }
    }

    public void delete(int id){
        try{
            studentDao.delete(id);
        }catch(Exception ex){

        }
    }

    public List<Student> getAll(){
        List<Student> students = null;
        try{
            students = studentDao.getAll();
        }catch(Exception ex){

        }
        return students;
    }
}

