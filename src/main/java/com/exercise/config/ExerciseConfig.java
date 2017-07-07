package com.exercise.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Ibukun.Ogunsolu on 7/1/2017.
 */
@Configuration
@ComponentScan("com.exercise")
public class ExerciseConfig extends WebMvcConfigurerAdapter {
}
