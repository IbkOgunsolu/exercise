package com.exercise.service;

import com.exercise.dao.SubjectDao;
import com.exercise.models.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ibukun.Ogunsolu on 7/2/2017.
 */
@Service
public class SubjectService {

    private final SubjectDao subjectDao;

    @Autowired
    public SubjectService(SubjectDao subjectDao){
        this.subjectDao = subjectDao;
    }

    public Subject create(Subject model){
        Subject subject = null;
        try{
            subject = subjectDao.create(model);
        }catch(Exception ex){

        }
        return subject;
    }

    public Subject get(int id){
        Subject subject = null;
        try{
            subject = subjectDao.get(id);
        }catch(Exception ex){

        }
        return subject;
    }

    public Subject update(Subject model){
        Subject subject = null;
        try{
            subject = subjectDao.update(model);
        }catch(Exception ex){

        }
        return subject;
    }

    public void delete(Subject model){
        try{
            subjectDao.delete(model);
        }catch(Exception ex){

        }
    }

    public void delete(int id){
        try{
            subjectDao.delete(id);
        }catch(Exception ex){

        }
    }

    public List<Subject> getAll(){
        List<Subject> subjects = null;
        try{
            subjects = subjectDao.getAll();
        }catch(Exception ex){

        }
        return subjects;
    }
}

