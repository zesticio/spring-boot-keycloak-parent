package com.zestic.authy.app.service;

import com.zestic.authy.app.config.KeycloakManager;
import com.zestic.authy.app.config.KeycloakProperties;
import com.zestic.springboot.common.entity.Result;
import com.zestic.springboot.common.util.HTTPErrorCodes;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.RoleRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService extends BaseService {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(RoleService.class);

    protected final KeycloakProperties properties;
    protected final KeycloakManager manager;

    public RoleService(KeycloakProperties properties, KeycloakManager manager) {
        this.properties = properties;
        this.manager = manager;
    }

    public Result find() {
        Result<List<RoleRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        Keycloak keycloak = this.manager.getKeycloak();
        List<RoleRepresentation> list = keycloak.realm(properties.getRealm()).roles().list();
        result.setData(list);
        return result;
    }

    public Result findByName(final String name) {
        Result<RoleRepresentation> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        RoleRepresentation role = keycloak.realm(properties.getRealm()).roles().get(name).toRepresentation();
        result.setData(role);
        return result;
    }
}
