package com.exercise.controller.service;

import com.exercise.models.Contact;
import com.exercise.models.view.ViewResponse;
import com.exercise.service.ContactService;
import org.apache.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ibukun.Ogunsolu on 7/2/2017.
 */
@Service
public class ContactApiService {
    private final ContactService contactService;
    private static final Logger logger = LoggerFactory.getLogger(ContactApiService.class);

    @Autowired
    public ContactApiService(ContactService contactService){
        this.contactService = contactService;
    }

    public ViewResponse<Contact> create(Contact model){
        ViewResponse viewResponse = new ViewResponse();
        try{
            Contact contact = contactService.create(model);
            List<Contact> contactList = new ArrayList();
            contactList.add(contact);
            viewResponse.setModelList(contactList);
            viewResponse.setResponseCode("00");
            viewResponse.setResponseMessage("Successful");
        }catch(Exception ex){
            viewResponse.setResponseCode("96");
            viewResponse.setResponseMessage("System Malfunctioned");
            logger.error(ex.getMessage(), ex);
        }
        return viewResponse;
    }

    public ViewResponse<Contact> get(int id){
        ViewResponse viewResponse = new ViewResponse();
        try{
            Contact contact = contactService.get(id);
            List<Contact> contactList = new ArrayList();
            contactList.add(contact);
            viewResponse.setModelList(contactList);
            viewResponse.setResponseCode("00");
            viewResponse.setResponseMessage("Successful");
        }catch(Exception ex){
            viewResponse.setResponseCode("96");
            viewResponse.setResponseMessage("System Malfunctioned");
            logger.error(ex.getMessage(), ex);
        }
        return viewResponse;
    }

    public ViewResponse update(Contact model){
        ViewResponse viewResponse = new ViewResponse();
        try{
            Contact contact = contactService.update(model);
            List<Contact> contactList = new ArrayList();
            contactList.add(contact);
            viewResponse.setModelList(contactList);
            viewResponse.setResponseCode("00");
            viewResponse.setResponseMessage("Successful");
        }catch(Exception ex){
            viewResponse.setResponseCode("96");
            viewResponse.setResponseMessage("System Malfunctioned");
            logger.error(ex.getMessage(), ex);
        }
        return viewResponse;
    }

    public ViewResponse delete(Contact model){
        ViewResponse viewResponse = new ViewResponse();
        try{
            contactService.delete(model);
            viewResponse.setResponseCode("00");
            viewResponse.setResponseMessage("Successful");
        }catch(Exception ex){
            viewResponse.setResponseCode("96");
            viewResponse.setResponseMessage("System Malfunctioned");
            logger.error(ex.getMessage(), ex);
        }
        return viewResponse;
    }

    public ViewResponse delete(int id){
        ViewResponse viewResponse = new ViewResponse();
        try{
            contactService.delete(id);
            viewResponse.setResponseCode("00");
            viewResponse.setResponseMessage("Successful");
        }catch(Exception ex){
            viewResponse.setResponseCode("96");
            viewResponse.setResponseMessage("System Malfunctioned");
            logger.error(ex.getMessage(), ex);
        }
        return viewResponse;
    }

}
