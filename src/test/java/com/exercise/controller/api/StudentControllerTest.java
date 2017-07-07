package com.exercise.controller.api;

import com.exercise.config.test.TestConfig;
import com.exercise.models.Student;
import com.exercise.service.StudentService;
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
public class StudentControllerTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    Student student;
    @Autowired
    StudentService studentService;

    private Student getStudent(){
        Student student = new Student();
        student.setDiscipline("science");
        return student;
    }

    @Before
    public void setup() {
        student = getStudent();
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testCreateStudent() throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        String studentString = mapper.writeValueAsString(student);

        this.mockMvc.perform(post("/api/v1/students")
                .contentType(MediaType.APPLICATION_JSON)
                .content(studentString)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateStudent() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String studentString = mapper.writeValueAsString(student);

        this.mockMvc.perform(put("/api/v1/students")
                .contentType(MediaType.APPLICATION_JSON)
                .content(studentString)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void testGetStudent() throws Exception {
        studentService.create(student);

        this.mockMvc.perform(get("/api/v1/students/get")
                .contentType(MediaType.APPLICATION_JSON)
                .requestAttr("id", student.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    @Test
    public void testGetAllStudents() throws Exception {

        this.mockMvc.perform(get("/api/v1/students/all")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}