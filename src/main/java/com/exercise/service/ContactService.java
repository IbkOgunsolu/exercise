package com.exercise.service;

import com.exercise.dao.ContactDao;
import com.exercise.models.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Ibukun.Ogunsolu on 7/2/2017.
 */
@Service
public class ContactService {

    private final ContactDao contactDao;

    @Autowired
    public ContactService(ContactDao contactDao){
        this.contactDao = contactDao;
    }

    public Contact create(Contact model){
        Contact contact = null;
        try{
            contact = contactDao.create(model);
        }catch(Exception ex){

        }
        return contact;
    }

    public Contact get(int id){
        Contact contact = null;
        try{
            contact = contactDao.get(id);
        }catch(Exception ex){

        }
        return contact;
    }

    public Contact update(Contact model){
        Contact contact = null;
        try{
            contact = contactDao.update(model);
        }catch(Exception ex){

        }
        return contact;
    }

    public void delete(Contact model){
        try{
            contactDao.delete(model);
        }catch(Exception ex){

        }
    }

    public void delete(int id){
        try{
            contactDao.delete(id);
        }catch(Exception ex){

        }
    }


}
