package com.exercise.controller.api;

import com.exercise.config.test.TestConfig;
import com.exercise.models.Subject;
import com.exercise.service.SubjectService;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Ibukun.Ogunsolu on 7/2/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {TestConfig.class})
@TestPropertySource(locations = {"classpath:test.properties"})
@WebAppConfiguration
public class SubjectControllerTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    Subject subject;
    @Autowired
    SubjectService subjectService;

    private Subject getSubject(){
        Subject subject = new Subject();
        subject.setDescription("physics");
        subject.setCode("PHY001");
        subject.setName("elementary physics");
        return subject;
    }

    @Before
    public void setup() {
        subject = getSubject();
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testCreateSubject() throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        String subjectString = mapper.writeValueAsString(subject);

        this.mockMvc.perform(post("/api/v1/subjects")
                .contentType(MediaType.APPLICATION_JSON)
                .content(subjectString)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateSubject() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String subjectString = mapper.writeValueAsString(subject);

        this.mockMvc.perform(put("/api/v1/subjects")
                .contentType(MediaType.APPLICATION_JSON)
                .content(subjectString)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void testGetSubject() throws Exception {
        subjectService.create(subject);

        this.mockMvc.perform(get("/api/v1/subjects")
                .contentType(MediaType.APPLICATION_JSON)
                .requestAttr("id", subject.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAllSubjects() throws Exception {

        this.mockMvc.perform(get("/api/v1/subjects/all")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}