package com.zestic.authy.app.service;

import com.zestic.authy.app.config.KeycloakProperties;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RealmResource;

public class BaseService {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(BaseService.class);

    protected KeycloakProperties properties;
    protected Keycloak keycloak;
    protected RealmResource realmResource;

}
