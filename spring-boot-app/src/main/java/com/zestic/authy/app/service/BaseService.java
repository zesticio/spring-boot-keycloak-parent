package com.zestic.authy.app.service;

import com.zestic.authy.app.config.KeycloakAdminClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.RefreshableKeycloakSecurityContext;
import org.keycloak.adapters.springboot.KeycloakSpringBootProperties;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.token.TokenManager;
import org.keycloak.representations.AccessToken;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.security.core.context.SecurityContextHolder;

public class BaseService {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(BaseService.class);

    protected final KeycloakSpringBootProperties properties;
    protected Keycloak keycloak;
    protected RealmResource realmResource;

    public BaseService(KeycloakSpringBootProperties properties) {
        this.properties = properties;
    }

    protected Keycloak getKeycloakInstance() {
        KeycloakPrincipal<RefreshableKeycloakSecurityContext> principal = getPrincipal();
        keycloak = KeycloakAdminClient.builder()
                .properties(this.properties)
                .session(principal.getKeycloakSecurityContext())
                .build();
        return keycloak;
    }

    protected Keycloak getKeycloakInstance(String username, String password) {
        keycloak = KeycloakBuilder.builder()
                .serverUrl(this.properties.getAuthServerUrl())
                .realm(this.properties.getRealm())
                .username(username)
                .password(password)
                .clientId(this.properties.getResource())
                .resteasyClient(new ResteasyClientBuilder().connectionPoolSize(this.properties.getConnectionPoolSize()).build())
                .build();
        TokenManager tokenManager = keycloak.tokenManager();
        AccessTokenResponse accessTokenResponse = tokenManager.getAccessToken();
        logger.info(accessTokenResponse.getRefreshToken());
        logger.info(tokenManager.refreshToken().getRefreshToken());
        return keycloak;
    }

    protected String getUsername() {
        KeycloakPrincipal<RefreshableKeycloakSecurityContext> principal = getPrincipal();
        final KeycloakSecurityContext keycloakSecurityContext = principal.getKeycloakSecurityContext();
        return keycloakSecurityContext.getToken().getPreferredUsername();
    }

    protected AccessToken getAccessToken() {
        KeycloakPrincipal<RefreshableKeycloakSecurityContext> principal = getPrincipal();
        final KeycloakSecurityContext keycloakSecurityContext = principal.getKeycloakSecurityContext();
        return keycloakSecurityContext.getToken();
    }

    private KeycloakPrincipal<RefreshableKeycloakSecurityContext> getPrincipal() {
        return (KeycloakPrincipal<RefreshableKeycloakSecurityContext>) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
