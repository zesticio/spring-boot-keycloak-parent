package com.zestic.authy.app.service;

import com.zestic.authy.app.config.KeycloakAdminClient;
import com.zestic.authy.keycloak.entity.User;
import com.zestic.common.entity.Result;
import com.zestic.common.utils.HTTPErrorCodes;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.adapters.RefreshableKeycloakSecurityContext;
import org.keycloak.adapters.springboot.KeycloakSpringBootProperties;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(UserService.class);

    private final KeycloakSpringBootProperties properties;

    public UserService(KeycloakSpringBootProperties properties) {
        this.properties = properties;
    }

    public Result find() {
        Result<List<UserRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        Keycloak keycloak = getKeycloakInstance();
        UsersResource usersResource = keycloak.realm(properties.getRealm()).users();
        result.setData(usersResource.list());
        return result;
    }

    public Result create() {
        Result<User> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }

    public Result update(String id) {
        Result<User> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }

    public Result findById(String id) {
        Result<UserRepresentation> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        Keycloak keycloak = getKeycloakInstance();
        UserResource user = keycloak.realm(properties.getRealm()).users().get(id);
        result.setData(user.toRepresentation());
        return result;
    }

    private Keycloak getKeycloakInstance() {
        KeycloakPrincipal<RefreshableKeycloakSecurityContext> principal = getPrincipal();
        return KeycloakAdminClient.builder()
                .properties(this.properties)
                .session(principal.getKeycloakSecurityContext())
                .build();
    }

    private KeycloakPrincipal<RefreshableKeycloakSecurityContext> getPrincipal() {
        return (KeycloakPrincipal<RefreshableKeycloakSecurityContext>) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
