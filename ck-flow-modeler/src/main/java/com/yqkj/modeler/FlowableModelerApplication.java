package com.yqkj.modeler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class FlowableModelerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlowableModelerApplication.class, args);
    }

}
