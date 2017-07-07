package com.exercise.controller.service;

import com.exercise.models.Application;
import com.exercise.models.ApplicationStatus;
import com.exercise.models.view.ViewResponse;
import com.exercise.service.ApplicationService;
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
public class ApplicationApiService {
    private final ApplicationService applicationService;
    private static final Logger logger = LoggerFactory.getLogger(ApplicationApiService.class);

    @Autowired
    public ApplicationApiService(ApplicationService applicationService){
        this.applicationService = applicationService;
    }

    public ViewResponse<Application> create(Application model){
        ViewResponse viewResponse = new ViewResponse();
        try{
            model.setStatus(ApplicationStatus.PENDING);
            Application application = applicationService.create(model);
            List<Application> applicationList = new ArrayList();
            applicationList.add(application);
            viewResponse.setModelList(applicationList);
            viewResponse.setResponseCode("00");
            viewResponse.setResponseMessage("Successful");
        }catch(Exception ex){
            viewResponse.setResponseCode("96");
            viewResponse.setResponseMessage("System Malfunctioned");
            logger.error(ex.getMessage(), ex);
        }
        return viewResponse;
    }

    public ViewResponse<Application> get(int id){
        ViewResponse viewResponse = new ViewResponse();
        try{
            Application application = applicationService.get(id);
            List<Application> applicationList = new ArrayList();
            applicationList.add(application);
            viewResponse.setModelList(applicationList);
            viewResponse.setResponseCode("00");
            viewResponse.setResponseMessage("Successful");
        }catch(Exception ex){
            viewResponse.setResponseCode("96");
            viewResponse.setResponseMessage("System Malfunctioned");
            logger.error(ex.getMessage(), ex);
        }
        return viewResponse;
    }

    public ViewResponse<Application> getAll(){
        ViewResponse viewResponse = new ViewResponse();
        try{
            List<Application> applicationList = applicationService.getAll();
            viewResponse.setModelList(applicationList);
            viewResponse.setCount(applicationList.size());
            viewResponse.setResponseCode("00");
            viewResponse.setResponseMessage("Successful");
        }catch(Exception ex){
            viewResponse.setResponseCode("96");
            viewResponse.setResponseMessage("System Malfunctioned");
            logger.error(ex.getMessage(), ex);
        }
        return viewResponse;
    }

    public ViewResponse update(Application model){
        ViewResponse viewResponse = new ViewResponse();
        try{
            Application application = applicationService.update(model);
            List<Application> applicationList = new ArrayList();
            applicationList.add(application);
            viewResponse.setModelList(applicationList);
            viewResponse.setResponseCode("00");
            viewResponse.setResponseMessage("Successful");
        }catch(Exception ex){
            viewResponse.setResponseCode("96");
            viewResponse.setResponseMessage("System Malfunctioned");
            logger.error(ex.getMessage(), ex);
        }
        return viewResponse;
    }

    public ViewResponse delete(Application model){
        ViewResponse viewResponse = new ViewResponse();
        try{
            applicationService.delete(model);
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
            applicationService.delete(id);
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

