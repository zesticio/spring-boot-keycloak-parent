package com.zestic.authy.keycloak.config;

import com.zestic.authy.keycloak.Client;
import com.zestic.authy.keycloak.exception.KeycloakException;
import com.zestic.log.Log;
import com.zestic.log.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
@Configuration
@EnableConfigurationProperties(KeycloakProperties.class)
public class KeycloakAutoConfiguration implements ApplicationContextAware {

    private Log logger = LogFactory.get();
    private ApplicationContext applicationContext;
    private KeycloakProperties properties;

    public KeycloakAutoConfiguration(KeycloakProperties properties) {
        this.properties = properties;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Bean
    public Client pcap4JConfigBean() throws KeycloakException {
        Client client = null;
        return client;
    }
}
