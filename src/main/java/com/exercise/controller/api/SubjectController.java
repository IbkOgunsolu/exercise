package com.exercise.controller.api;

import com.exercise.controller.service.SubjectApiService;
import com.exercise.models.Subject;
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
@RequestMapping(value = "api/v1/subjects")
public class SubjectController {

    private final SubjectApiService subjectApiService;

    @Autowired
    public SubjectController(SubjectApiService subjectApiService) {
        this.subjectApiService = subjectApiService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Callable<ResponseEntity<ViewResponse<Subject>>> createSubject(@Validated @RequestBody Subject subject) {
        return new Callable<ResponseEntity<ViewResponse<Subject> >>() {
            public ResponseEntity<ViewResponse<Subject> > call() throws Exception {
                ViewResponse<Subject>  viewResponse = subjectApiService.create(subject);
                return new ResponseEntity<ViewResponse<Subject> >(viewResponse, HttpStatus.OK);
            }
        };
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Callable<ResponseEntity<ViewResponse<Subject>>> updateSubject(@Validated @RequestBody Subject subject) {
        return new Callable<ResponseEntity<ViewResponse<Subject> >>() {
            public ResponseEntity<ViewResponse<Subject> > call() throws Exception {
                ViewResponse<Subject>  viewResponse = subjectApiService.update(subject);
                return new ResponseEntity<ViewResponse<Subject> >(viewResponse, HttpStatus.OK);
            }
        };
    }

    @RequestMapping(method = RequestMethod.GET, params = {"id"})
    public Callable<ResponseEntity<ViewResponse<Subject>>> getSubject(@RequestParam("id") int id) {
        return new Callable<ResponseEntity<ViewResponse<Subject> >>() {
            public ResponseEntity<ViewResponse<Subject> > call() throws Exception {
                ViewResponse<Subject>  viewResponse = subjectApiService.get(id);
                return new ResponseEntity<ViewResponse<Subject> >(viewResponse, HttpStatus.OK);
            }
        };
    }

    @RequestMapping(method = RequestMethod.GET,  value = "/all")
    public Callable<ResponseEntity<ViewResponse<Subject>>> getAllSubjects() {
        return new Callable<ResponseEntity<ViewResponse<Subject> >>() {
            public ResponseEntity<ViewResponse<Subject> > call() throws Exception {
                ViewResponse<Subject>  viewResponse = subjectApiService.getAll();
                return new ResponseEntity<ViewResponse<Subject> >(viewResponse, HttpStatus.OK);
            }
        };
    }
}

