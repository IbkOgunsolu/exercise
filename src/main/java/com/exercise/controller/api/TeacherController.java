package com.exercise.controller.api;

import com.exercise.controller.service.TeacherApiService;
import com.exercise.models.Teacher;
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
@RequestMapping(value = "api/v1/teachers")
public class TeacherController {

    private final TeacherApiService teacherApiService;

    @Autowired
    public TeacherController(TeacherApiService teacherApiService) {
        this.teacherApiService = teacherApiService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Callable<ResponseEntity<ViewResponse<Teacher>>> createTeacher(@Validated @RequestBody Teacher teacher) {
        return new Callable<ResponseEntity<ViewResponse<Teacher> >>() {
            public ResponseEntity<ViewResponse<Teacher> > call() throws Exception {
                ViewResponse<Teacher>  viewResponse = teacherApiService.create(teacher);
                return new ResponseEntity<ViewResponse<Teacher> >(viewResponse, HttpStatus.OK);
            }
        };
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Callable<ResponseEntity<ViewResponse<Teacher>>> updateTeacher(@Validated @RequestBody Teacher teacher) {
        return new Callable<ResponseEntity<ViewResponse<Teacher> >>() {
            public ResponseEntity<ViewResponse<Teacher> > call() throws Exception {
                ViewResponse<Teacher>  viewResponse = teacherApiService.update(teacher);
                return new ResponseEntity<ViewResponse<Teacher> >(viewResponse, HttpStatus.OK);
            }
        };
    }

    @RequestMapping(method = RequestMethod.GET, params = {"id"})
    public Callable<ResponseEntity<ViewResponse<Teacher>>> getTeacher(@RequestParam("id") int id) {
        return new Callable<ResponseEntity<ViewResponse<Teacher> >>() {
            public ResponseEntity<ViewResponse<Teacher> > call() throws Exception {
                ViewResponse<Teacher>  viewResponse = teacherApiService.get(id);
                return new ResponseEntity<ViewResponse<Teacher> >(viewResponse, HttpStatus.OK);
            }
        };
    }

    @RequestMapping(method = RequestMethod.GET,  value = "/all")
    public Callable<ResponseEntity<ViewResponse<Teacher>>> getTeacher() {
        return new Callable<ResponseEntity<ViewResponse<Teacher> >>() {
            public ResponseEntity<ViewResponse<Teacher> > call() throws Exception {
                ViewResponse<Teacher>  viewResponse = teacherApiService.getAll();
                return new ResponseEntity<ViewResponse<Teacher> >(viewResponse, HttpStatus.OK);
            }
        };
    }
}

