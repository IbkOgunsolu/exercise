package com.exercise.controller.api;

import com.exercise.config.test.TestConfig;
import com.exercise.models.Teacher;
import com.exercise.service.TeacherService;
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
public class TeacherControllerTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    Teacher teacher;
    @Autowired
    TeacherService teacherService;

    private Teacher getTeacher(){
        Teacher teacher = new Teacher();
        teacher.setDesignation("P.Hd.");
        return teacher;
    }

    @Before
    public void setup() {
        teacher = getTeacher();
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testCreateTeacher() throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        String teacherString = mapper.writeValueAsString(teacher);

        this.mockMvc.perform(post("/api/v1/teachers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(teacherString)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateTeacher() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String teacherString = mapper.writeValueAsString(teacher);

        this.mockMvc.perform(put("/api/v1/teachers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(teacherString)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void testGetTeacher() throws Exception {
        teacherService.create(teacher);

        this.mockMvc.perform(get("/api/v1/teachers")
                .contentType(MediaType.APPLICATION_JSON)
                .requestAttr("id", teacher.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAllTeachers() throws Exception {

        this.mockMvc.perform(get("/api/v1/teachers/all")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}