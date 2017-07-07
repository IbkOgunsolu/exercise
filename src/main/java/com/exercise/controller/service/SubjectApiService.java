package com.exercise.controller.service;

import com.exercise.models.Subject;
import com.exercise.models.view.ViewResponse;
import com.exercise.service.SubjectService;
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
public class SubjectApiService {
    private final SubjectService subjectService;
    private static final Logger logger = LoggerFactory.getLogger(SubjectApiService.class);

    @Autowired
    public SubjectApiService(SubjectService subjectService){
        this.subjectService = subjectService;
    }

    public ViewResponse<Subject> create(Subject model){
        ViewResponse viewResponse = new ViewResponse();
        try{
            Subject subject = subjectService.create(model);
            List<Subject> subjectList = new ArrayList();
            subjectList.add(subject);
            viewResponse.setModelList(subjectList);
            viewResponse.setResponseCode("00");
            viewResponse.setResponseMessage("Successful");
        }catch(Exception ex){
            viewResponse.setResponseCode("96");
            viewResponse.setResponseMessage("System Malfunctioned");
            logger.error(ex.getMessage(), ex);
        }
        return viewResponse;
    }

    public ViewResponse<Subject> get(int id){
        ViewResponse viewResponse = new ViewResponse();
        try{
            Subject subject = subjectService.get(id);
            List<Subject> subjectList = new ArrayList();
            subjectList.add(subject);
            viewResponse.setModelList(subjectList);
            viewResponse.setResponseCode("00");
            viewResponse.setResponseMessage("Successful");
        }catch(Exception ex){
            viewResponse.setResponseCode("96");
            viewResponse.setResponseMessage("System Malfunctioned");
            logger.error(ex.getMessage(), ex);
        }
        return viewResponse;
    }

    public ViewResponse<Subject> getAll(){
        ViewResponse viewResponse = new ViewResponse();
        try{
            List<Subject> subjectList = subjectService.getAll();
            viewResponse.setModelList(subjectList);
            viewResponse.setCount(subjectList.size());
            viewResponse.setResponseCode("00");
            viewResponse.setResponseMessage("Successful");
        }catch(Exception ex){
            viewResponse.setResponseCode("96");
            viewResponse.setResponseMessage("System Malfunctioned");
            logger.error(ex.getMessage(), ex);
        }
        return viewResponse;
    }

    public ViewResponse update(Subject model){
        ViewResponse viewResponse = new ViewResponse();
        try{
            Subject subject = subjectService.update(model);
            List<Subject> subjectList = new ArrayList();
            subjectList.add(subject);
            viewResponse.setModelList(subjectList);
            viewResponse.setResponseCode("00");
            viewResponse.setResponseMessage("Successful");
        }catch(Exception ex){
            viewResponse.setResponseCode("96");
            viewResponse.setResponseMessage("System Malfunctioned");
            logger.error(ex.getMessage(), ex);
        }
        return viewResponse;
    }

    public ViewResponse delete(Subject model){
        ViewResponse viewResponse = new ViewResponse();
        try{
            subjectService.delete(model);
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
            subjectService.delete(id);
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

