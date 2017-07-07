package com.exercise.controller.api;

import com.exercise.config.test.TestConfig;
import com.exercise.models.Application;
import com.exercise.models.ApplicationStatus;
import com.exercise.service.ApplicationService;
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
public class ApplicationControllerTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    Application application;
    @Autowired
    ApplicationService applicationService;

    private Application getApplication(){
        Application application = new Application();
        application.setStatementOfPurpose("I am a great student");
        application.setStatus(ApplicationStatus.PENDING);
        return application;
    }

    @Before
    public void setup() {
        application = getApplication();
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testCreateApplication() throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        String applicationString = mapper.writeValueAsString(application);

        this.mockMvc.perform(post("/api/v1/applications")
                .contentType(MediaType.APPLICATION_JSON)
                .content(applicationString)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateApplication() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String applicationString = mapper.writeValueAsString(application);

        this.mockMvc.perform(put("/api/v1/applications")
                .contentType(MediaType.APPLICATION_JSON)
                .content(applicationString)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void testGetApplication() throws Exception {
        applicationService.create(application);

        this.mockMvc.perform(get("/api/v1/applications")
                .contentType(MediaType.APPLICATION_JSON)
                .requestAttr("id", application.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAllApplications() throws Exception {

        this.mockMvc.perform(get("/api/v1/applications/all")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}