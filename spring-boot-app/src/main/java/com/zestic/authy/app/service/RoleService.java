package com.zestic.authy.app.service;

import com.zestic.common.entity.Result;
import com.zestic.common.utils.HTTPErrorCodes;
import org.keycloak.adapters.springboot.KeycloakSpringBootProperties;
import org.keycloak.representations.idm.RoleRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService extends BaseService {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(RoleService.class);

    @Value("${spring.keycloak.username}")
    private String username;
    @Value("${spring.keycloak.password}")
    private String password;

    public RoleService(KeycloakSpringBootProperties properties) {
        super(properties);
    }

    public Result find() {
        Result<List<RoleRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        keycloak = getKeycloakInstance();
        List<RoleRepresentation> list = keycloak.realm(properties.getRealm()).roles().list();
        result.setData(list);
        return result;
    }

    public Result findByName(final String name) {
        Result<RoleRepresentation> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        keycloak = getKeycloakInstance();
        RoleRepresentation role = keycloak.realm(properties.getRealm()).roles().get(name).toRepresentation();
        result.setData(role);
        return result;
    }

}
