package com.zestic.authy.app.config;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.OAuth2Constants;
import org.keycloak.adapters.springboot.KeycloakSpringBootProperties;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;

public class KeycloakAdminClient {

    private final KeycloakSpringBootProperties properties;
    private KeycloakSecurityContext session;

    public KeycloakAdminClient(Builder builder) {
        this.properties = builder.properties;
        this.session = builder.session;
    }

    public static Builder builder() {
        return new Builder();
    }

    protected Keycloak create() {
        return KeycloakBuilder.builder() //
                .serverUrl(this.properties.getAuthServerUrl()) //
                .realm(this.properties.getRealm()) //
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS) //
                .clientId(this.properties.getResource()) //
                .clientSecret((String) this.properties.getCredentials().get("secret")) //
                .authorization(session.getTokenString()) //
                .resteasyClient(new ResteasyClientBuilder()
                        .connectionPoolSize(properties.getConnectionPoolSize())
                        .build())
                .build();
    }

    public static class Builder {
        private KeycloakSpringBootProperties properties;
        private KeycloakSecurityContext session;

        private Builder() {
        }

        public Builder properties(KeycloakSpringBootProperties properties) {
            this.properties = properties;
            return this;
        }

        public Builder session(KeycloakSecurityContext session) {
            this.session = session;
            return this;
        }

        public Keycloak build() {
            return new KeycloakAdminClient(this).create();
        }
    }
}
