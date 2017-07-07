package com.exercise.controller.service;

import com.exercise.models.Teacher;
import com.exercise.models.view.ViewResponse;
import com.exercise.service.TeacherService;
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
public class TeacherApiService {
    private final TeacherService teacherService;
    private static final Logger logger = LoggerFactory.getLogger(TeacherApiService.class);

    @Autowired
    public TeacherApiService(TeacherService teacherService){
        this.teacherService = teacherService;
    }

    public ViewResponse<Teacher> create(Teacher model){
        ViewResponse viewResponse = new ViewResponse();
        try{
            Teacher teacher = teacherService.create(model);
            List<Teacher> teacherList = new ArrayList();
            teacherList.add(teacher);
            viewResponse.setModelList(teacherList);
            viewResponse.setResponseCode("00");
            viewResponse.setResponseMessage("Successful");
        }catch(Exception ex){
            viewResponse.setResponseCode("96");
            viewResponse.setResponseMessage("System Malfunctioned");
            logger.error(ex.getMessage(), ex);
        }
        return viewResponse;
    }

    public ViewResponse<Teacher> get(int id){
        ViewResponse viewResponse = new ViewResponse();
        try{
            Teacher teacher = teacherService.get(id);
            List<Teacher> teacherList = new ArrayList();
            teacherList.add(teacher);
            viewResponse.setModelList(teacherList);
            viewResponse.setResponseCode("00");
            viewResponse.setResponseMessage("Successful");
        }catch(Exception ex){
            viewResponse.setResponseCode("96");
            viewResponse.setResponseMessage("System Malfunctioned");
            logger.error(ex.getMessage(), ex);
        }
        return viewResponse;
    }

    public ViewResponse<Teacher> getAll(){
        ViewResponse viewResponse = new ViewResponse();
        try{
            List<Teacher> teacherList = teacherService.getAll();
            viewResponse.setModelList(teacherList);
            viewResponse.setCount(teacherList.size());
            viewResponse.setResponseCode("00");
            viewResponse.setResponseMessage("Successful");
        }catch(Exception ex){
            viewResponse.setResponseCode("96");
            viewResponse.setResponseMessage("System Malfunctioned");
            logger.error(ex.getMessage(), ex);
        }
        return viewResponse;
    }
    public ViewResponse update(Teacher model){
        ViewResponse viewResponse = new ViewResponse();
        try{
            Teacher teacher = teacherService.update(model);
            List<Teacher> teacherList = new ArrayList();
            teacherList.add(teacher);
            viewResponse.setModelList(teacherList);
            viewResponse.setResponseCode("00");
            viewResponse.setResponseMessage("Successful");
        }catch(Exception ex){
            viewResponse.setResponseCode("96");
            viewResponse.setResponseMessage("System Malfunctioned");
            logger.error(ex.getMessage(), ex);
        }
        return viewResponse;
    }

    public ViewResponse delete(Teacher model){
        ViewResponse viewResponse = new ViewResponse();
        try{
            teacherService.delete(model);
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
            teacherService.delete(id);
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

