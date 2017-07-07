package com.exercise.controller.api;

import com.exercise.controller.service.ApplicationApiService;
import com.exercise.models.Application;
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
@RequestMapping(value = "api/v1/applications")
public class ApplicationController {

    private final ApplicationApiService applicationApiService;

    @Autowired
    public ApplicationController(ApplicationApiService applicationApiService) {
        this.applicationApiService = applicationApiService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Callable<ResponseEntity<ViewResponse<Application>>> createApplication(@Validated @RequestBody Application application) {
        return new Callable<ResponseEntity<ViewResponse<Application> >>() {
            public ResponseEntity<ViewResponse<Application> > call() throws Exception {
                ViewResponse<Application>  viewResponse = applicationApiService.create(application);
                return new ResponseEntity<ViewResponse<Application> >(viewResponse, HttpStatus.OK);
            }
        };
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Callable<ResponseEntity<ViewResponse<Application>>> updateApplication(@Validated @RequestBody final Application application) {
        return new Callable<ResponseEntity<ViewResponse<Application> >>() {
            public ResponseEntity<ViewResponse<Application> > call() throws Exception {
                ViewResponse<Application>  viewResponse = applicationApiService.update(application);
                return new ResponseEntity<ViewResponse<Application> >(viewResponse, HttpStatus.OK);
            }
        };
    }

    @RequestMapping(method = RequestMethod.GET, params = {"id"})
    public Callable<ResponseEntity<ViewResponse<Application>>> getApplication(@RequestParam("id") int id) {
        return new Callable<ResponseEntity<ViewResponse<Application> >>() {
            public ResponseEntity<ViewResponse<Application> > call() throws Exception {
                ViewResponse<Application>  viewResponse = applicationApiService.get(id);
                return new ResponseEntity<ViewResponse<Application> >(viewResponse, HttpStatus.OK);
            }
        };
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public Callable<ResponseEntity<ViewResponse<Application>>> getAllApplications() {
        return new Callable<ResponseEntity<ViewResponse<Application> >>() {
            public ResponseEntity<ViewResponse<Application> > call() throws Exception {
                ViewResponse<Application>  viewResponse = applicationApiService.getAll();
                return new ResponseEntity<ViewResponse<Application> >(viewResponse, HttpStatus.OK);
            }
        };
    }

}

