package com.zestic.authy.keycloak.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

@Data
@ConfigurationProperties(prefix = "keycloak")
public class KeycloakProperties implements Serializable {

    private String clientId = "default";
    private String clientSecret = "";
    private String serverUrl = "https://127.0.0.1";
    private String realm = "master";
}
