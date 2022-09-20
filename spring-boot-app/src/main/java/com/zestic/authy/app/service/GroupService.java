package com.zestic.authy.app.service;

import com.zestic.authy.app.config.KeycloakManager;
import com.zestic.authy.app.config.KeycloakProperties;
import com.zestic.springboot.common.entity.Result;
import com.zestic.springboot.common.util.HTTPErrorCodes;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.GroupRepresentation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService extends BaseService {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(GroupService.class);

    protected final KeycloakProperties properties;
    protected final KeycloakManager manager;

    public GroupService(KeycloakProperties properties, KeycloakManager manager) {
        this.properties = properties;
        this.manager = manager;
    }

    public Result find() {
        Result<List<GroupRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        Keycloak keycloak = this.manager.getKeycloak();
        List<GroupRepresentation> list = keycloak.realm(properties.getRealm()).groups().groups();
        result.setData(list);
        return result;
    }

    public Result findByName(final String name) {
        Result<GroupRepresentation> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        GroupRepresentation groupRepresentation = keycloak.realm(properties.getRealm()).groups().group(name).toRepresentation();
        result.setData(groupRepresentation);
        return result;
    }

}
