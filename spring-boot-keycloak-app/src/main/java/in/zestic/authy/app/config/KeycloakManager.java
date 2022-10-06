package in.zestic.authy.app.config;

import lombok.Getter;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class KeycloakManager {

    private String username;
    private String password;
    private KeycloakProperties properties;
    @Getter
    private Keycloak keycloak;

    public KeycloakManager() {
    }

    private KeycloakManager(Builder builder) {
        this.username = builder.username;
        this.password = builder.password;
        this.properties = builder.properties;
    }

    public static class Builder {

        private String username;
        private String password;
        private KeycloakProperties properties;
        private Keycloak keycloak;

        public Builder() {
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder properties(KeycloakProperties properties) {
            this.properties = properties;
            return this;
        }

        public Keycloak build() {
            return keycloak = KeycloakBuilder.builder() //
                    .serverUrl(this.properties.getAuthServerUrl()) //
                    .realm(this.properties.getRealm()) //
                    .username(this.username)
                    .password(this.password)
                    .clientId(this.properties.getResourceName()) //
                    .clientSecret((String) this.properties.getResourceSecret()) //
                    .resteasyClient(new ResteasyClientBuilder()
                            .connectionPoolSize(this.properties.getConnectionPoolSize())
                            .build())
                    .build();
        }
    }
}
