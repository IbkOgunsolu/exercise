package com.exercise.service;

import com.exercise.dao.PersonDao;
import com.exercise.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Ibukun.Ogunsolu on 7/2/2017.
 */
@Service
public class PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonService(PersonDao personDao){
        this.personDao = personDao;
    }

    public Person create(Person model){
        Person person = null;
        try{
            person = personDao.create(model);
        }catch(Exception ex){

        }
        return person;
    }

    public Person get(int id){
        Person person = null;
        try{
            person = personDao.get(id);
        }catch(Exception ex){

        }
        return person;
    }

    public Person update(Person model){
        Person person = null;
        try{
            person = personDao.update(model);
        }catch(Exception ex){

        }
        return person;
    }

    public void delete(Person model){
        try{
            personDao.delete(model);
        }catch(Exception ex){

        }
    }

    public void delete(int id){
        try{
            personDao.delete(id);
        }catch(Exception ex){

        }
    }


}

