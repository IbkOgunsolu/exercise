package com.exercise.controller.api;

import com.exercise.controller.service.StudentApiService;
import com.exercise.models.Student;
import com.exercise.models.view.ViewResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.Callable;

/**
 * Created by Ibukun.Ogunsolu on 7/2/2017.
 */
@RestController
@RequestMapping(value = "api/v1/students")
public class StudentController {
    
    private final StudentApiService studentApiService;

    @Autowired
    public StudentController(StudentApiService studentApiService) {
        this.studentApiService = studentApiService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Callable<ResponseEntity<ViewResponse<Student>>> createStudent(@Validated @RequestBody Student student) {
        return new Callable<ResponseEntity<ViewResponse<Student> >>() {
            public ResponseEntity<ViewResponse<Student> > call() throws Exception {
                ViewResponse<Student>  viewResponse = studentApiService.create(student);
                return new ResponseEntity<ViewResponse<Student> >(viewResponse, HttpStatus.OK);
            }
        };
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Callable<ResponseEntity<ViewResponse<Student>>> updateStudent(@Validated @RequestBody Student student) {
        return new Callable<ResponseEntity<ViewResponse<Student> >>() {
            public ResponseEntity<ViewResponse<Student> > call() throws Exception {
                ViewResponse<Student>  viewResponse = studentApiService.update(student);
                return new ResponseEntity<ViewResponse<Student> >(viewResponse, HttpStatus.OK);
            }
        };
    }

    @RequestMapping(method = RequestMethod.GET, params = {"id"})
    public Callable<ResponseEntity<ViewResponse<Student>>> getStudent(@RequestParam("id") int id) {
        return new Callable<ResponseEntity<ViewResponse<Student> >>() {
            public ResponseEntity<ViewResponse<Student> > call() throws Exception {
                ViewResponse<Student>  viewResponse = studentApiService.get(id);
                return new ResponseEntity<ViewResponse<Student> >(viewResponse, HttpStatus.OK);
            }
        };
    }

    @RequestMapping(method = RequestMethod.GET,  value = "/all")
    public Callable<ResponseEntity<ViewResponse<Student>>> getAllStudents() {
        return new Callable<ResponseEntity<ViewResponse<Student> >>() {
            public ResponseEntity<ViewResponse<Student> > call() throws Exception {
                ViewResponse<Student>  viewResponse = studentApiService.getAll();
                return new ResponseEntity<ViewResponse<Student> >(viewResponse, HttpStatus.OK);
            }
        };
    }
}

