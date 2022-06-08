package com.zestic.authy.app;

import com.zestic.authy.keycloak.annotation.EnableKeycloakAuthentication;
import com.zestic.authy.keycloak.config.KeycloakSecurityConfiguration;
import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableKeycloakAuthentication
public class AppApplication {

    private static final Logger logger = LoggerFactory.getLogger(AppApplication.class.getSimpleName());
    private static ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }
}
