package com.exercise.controller.api;

import com.exercise.controller.service.ContactApiService;
import com.exercise.models.Contact;
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
@RequestMapping(value = "api/v1/contacts")
public class ContactController {

    private final ContactApiService contactApiService;

    @Autowired
    public ContactController(ContactApiService contactApiService) {
        this.contactApiService = contactApiService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Callable<ResponseEntity<ViewResponse<Contact>>> createContact(@Validated @RequestBody Contact contact) {
        return new Callable<ResponseEntity<ViewResponse<Contact> >>() {
            public ResponseEntity<ViewResponse<Contact> > call() throws Exception {
                ViewResponse<Contact>  viewResponse = contactApiService.create(contact);
                return new ResponseEntity<ViewResponse<Contact> >(viewResponse, HttpStatus.OK);
            }
        };
    }

    @RequestMapping(method = RequestMethod.PUT)
         public Callable<ResponseEntity<ViewResponse<Contact>>> updateContact(@Validated @RequestBody Contact contact) {
        return new Callable<ResponseEntity<ViewResponse<Contact> >>() {
            public ResponseEntity<ViewResponse<Contact> > call() throws Exception {
                ViewResponse<Contact>  viewResponse = contactApiService.update(contact);
                return new ResponseEntity<ViewResponse<Contact> >(viewResponse, HttpStatus.OK);
            }
        };
    }

    @RequestMapping(method = RequestMethod.GET,  params = {"id"})
    public Callable<ResponseEntity<ViewResponse<Contact>>> getContact(@RequestParam("id") int id) {
        return new Callable<ResponseEntity<ViewResponse<Contact> >>() {
            public ResponseEntity<ViewResponse<Contact> > call() throws Exception {
                ViewResponse<Contact>  viewResponse = contactApiService.get(id);
                return new ResponseEntity<ViewResponse<Contact> >(viewResponse, HttpStatus.OK);
            }
        };
    }

}
