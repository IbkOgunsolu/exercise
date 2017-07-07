package com.exercise.controller.service;

import com.exercise.models.Student;
import com.exercise.models.view.ViewResponse;
import com.exercise.service.StudentService;
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
public class StudentApiService {
    private final StudentService studentService;
    private static final Logger logger = LoggerFactory.getLogger(StudentApiService.class);

    @Autowired
    public StudentApiService(StudentService studentService){
        this.studentService = studentService;
    }

    public ViewResponse<Student> create(Student model){
        ViewResponse viewResponse = new ViewResponse();
        try{
            Student student = studentService.create(model);
            List<Student> studentList = new ArrayList();
            studentList.add(student);
            viewResponse.setModelList(studentList);
            viewResponse.setResponseCode("00");
            viewResponse.setResponseMessage("Successful");
        }catch(Exception ex){
            viewResponse.setResponseCode("96");
            viewResponse.setResponseMessage("System Malfunctioned");
            logger.error(ex.getMessage(), ex);
        }
        return viewResponse;
    }

    public ViewResponse<Student> get(int id){
        ViewResponse viewResponse = new ViewResponse();
        try{
            Student student = studentService.get(id);
            List<Student> studentList = new ArrayList();
            studentList.add(student);
            viewResponse.setModelList(studentList);
            viewResponse.setResponseCode("00");
            viewResponse.setResponseMessage("Successful");
        }catch(Exception ex){
            viewResponse.setResponseCode("96");
            viewResponse.setResponseMessage("System Malfunctioned");
            logger.error(ex.getMessage(), ex);
        }
        return viewResponse;
    }

    public ViewResponse<Student> getAll(){
        ViewResponse viewResponse = new ViewResponse();
        try{
            List<Student> studentList = studentService.getAll();
            viewResponse.setModelList(studentList);
            viewResponse.setCount(studentList.size());
            viewResponse.setResponseCode("00");
            viewResponse.setResponseMessage("Successful");
        }catch(Exception ex){
            viewResponse.setResponseCode("96");
            viewResponse.setResponseMessage("System Malfunctioned");
            logger.error(ex.getMessage(), ex);
        }
        return viewResponse;
    }


    public ViewResponse update(Student model){
        ViewResponse viewResponse = new ViewResponse();
        try{
            Student student = studentService.update(model);
            List<Student> studentList = new ArrayList();
            studentList.add(student);
            viewResponse.setModelList(studentList);
            viewResponse.setResponseCode("00");
            viewResponse.setResponseMessage("Successful");
        }catch(Exception ex){
            viewResponse.setResponseCode("96");
            viewResponse.setResponseMessage("System Malfunctioned");
            logger.error(ex.getMessage(), ex);
        }
        return viewResponse;
    }

    public ViewResponse delete(Student model){
        ViewResponse viewResponse = new ViewResponse();
        try{
            studentService.delete(model);
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
            studentService.delete(id);
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

