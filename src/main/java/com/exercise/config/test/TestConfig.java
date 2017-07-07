package com.exercise.config.test;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by Ibukun.Ogunsolu on 7/2/2017.
 */

@Configuration
@ComponentScan(basePackages = {"com.exercise"})
@EnableAutoConfiguration
@SpringBootApplication
@Conditional(TestConfigCondition.class)
public class TestConfig {

}
