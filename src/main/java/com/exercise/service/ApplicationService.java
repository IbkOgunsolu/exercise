package com.exercise.service;

import com.exercise.dao.ApplicationDao;
import com.exercise.models.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ibukun.Ogunsolu on 7/2/2017.
 */
@Service
public class ApplicationService {

    private final ApplicationDao applicationDao;

    @Autowired
    public ApplicationService(ApplicationDao applicationDao){
        this.applicationDao = applicationDao;
    }

    public Application create(Application model){
        Application application = null;
        try{
            application = applicationDao.create(model);
        }catch(Exception ex){

        }
        return application;
    }

    public Application get(int id){
        Application application = null;
        try{
            application = applicationDao.get(id);
        }catch(Exception ex){

        }
        return application;
    }

    public Application update(Application model){
        Application application = null;
        try{
            application = applicationDao.update(model);
        }catch(Exception ex){

        }
        return application;
    }

    public void delete(Application model){
        try{
            applicationDao.delete(model);
        }catch(Exception ex){

        }
    }

    public void delete(int id){
        try{
            applicationDao.delete(id);
        }catch(Exception ex){

        }
    }

    public List<Application> getAll(){
        List<Application> applications = null;
        try{
            applications = applicationDao.getAll();
        }catch(Exception ex){

        }
        return applications;
    }
}
