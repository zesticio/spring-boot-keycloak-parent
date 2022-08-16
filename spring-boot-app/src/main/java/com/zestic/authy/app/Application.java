package com.zestic.authy.app;

import com.zestic.authy.keycloak.annotation.EnableKeycloakAuthentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableKeycloakAuthentication
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class.getSimpleName());
    private static ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}