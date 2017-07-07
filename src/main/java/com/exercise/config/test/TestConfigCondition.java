package com.exercise.config.test;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by Ibukun.Ogunsolu on 7/2/2017.
 */
public class TestConfigCondition implements Condition {

    public boolean matches(ConditionContext context, AnnotatedTypeMetadata annoMetaData) {
        Boolean isTestEnv  = false;
        Environment env =  context.getEnvironment();
        String testservice = env.getProperty("application.context");
        if(testservice!=null &&  testservice.equals("test")) {
            isTestEnv = true;
        }
        return isTestEnv;
    }
}