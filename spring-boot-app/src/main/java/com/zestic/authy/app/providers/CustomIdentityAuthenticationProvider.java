package com.zestic.authy.app.providers;

import com.zestic.authy.app.config.KeycloakManager;
import com.zestic.authy.app.config.KeycloakProperties;
import org.keycloak.admin.client.Keycloak;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class CustomIdentityAuthenticationProvider implements AuthenticationProvider {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(CustomIdentityAuthenticationProvider.class);

    private final KeycloakProperties properties;

    public CustomIdentityAuthenticationProvider(KeycloakProperties properties) {
        this.properties = properties;
    }

    // TODO:
    // In this function we need to connect with identity provider
    // and validate the user
    // we are hardcoding for a single user for demo purposes
    UserDetails isValidUser(String username, String password) {
        logger.info("Client Id {" + username + "} Secret {" + password + "}");
        if (username != null && password != null) {
            Keycloak keycloak = new KeycloakManager.Builder()
                    .properties(properties)
                    .username(username)
                    .password(password)
                    .build();

            if (keycloak != null && !keycloak.isClosed()) {
                logger.info(keycloak.tokenManager().toString());
            }
            UserDetails user = User
                    .withUsername(username)
                    .password("NOT_DISCLOSED")
                    .roles("USER_ROLE")
                    .build();
            return user;
        }
        return null;
    }

    @Override
    public Authentication authenticate(Authentication authentication) {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserDetails userDetails = isValidUser(username, password);

        if (userDetails != null) {
            return new UsernamePasswordAuthenticationToken(
                    username,
                    password,
                    userDetails.getAuthorities());
        } else {
            throw new BadCredentialsException("Incorrect user credentials !!");
        }
    }

    @Override
    public boolean supports(Class<?> authenticationType) {
        return authenticationType
                .equals(UsernamePasswordAuthenticationToken.class);
    }
}