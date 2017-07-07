package com.exercise.program;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Ibukun.Ogunsolu on 7/1/2017.
 */
@Configuration
@ComponentScan(basePackages = {"com.exercise"})
@EnableAutoConfiguration
@SpringBootApplication
public class Program {
    public static void main(String... args) {
        SpringApplication.run(Program.class, args);
    }
}