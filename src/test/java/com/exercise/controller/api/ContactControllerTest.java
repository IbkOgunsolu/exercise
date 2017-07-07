package com.exercise.controller.api;

import com.exercise.config.test.TestConfig;
import com.exercise.models.Contact;
import com.exercise.service.ContactService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Ibukun.Ogunsolu on 7/2/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {TestConfig.class})
@TestPropertySource(locations = {"classpath:test.properties"})
@WebAppConfiguration
public class ContactControllerTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    Contact contact;
    @Autowired
    ContactService contactService;

    private Contact getContact(){
        Contact contact = new Contact();
        contact.setAddressLine1("2, adio street");
        contact.setAddressLine2("lekki");
        contact.setCity("lekki");
        contact.setState("lagos");
        contact.setCountry("nigeria");
        return contact;
    }

    @Before
    public void setup() {
        contact = getContact();
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testCreateContact() throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        String contactString = mapper.writeValueAsString(contact);

        this.mockMvc.perform(post("/api/v1/contacts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(contactString)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateContact() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String contactString = mapper.writeValueAsString(contact);

        this.mockMvc.perform(put("/api/v1/contacts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(contactString)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void testGetContact() throws Exception {
        contactService.create(contact);

        this.mockMvc.perform(get("/api/v1/contacts")
                .contentType(MediaType.APPLICATION_JSON)
                .requestAttr("id",5)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}