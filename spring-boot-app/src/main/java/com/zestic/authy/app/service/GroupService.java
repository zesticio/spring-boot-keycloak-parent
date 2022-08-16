package com.zestic.authy.app.service;

import com.zestic.common.entity.Result;
import com.zestic.common.utils.HTTPErrorCodes;
import org.keycloak.adapters.springboot.KeycloakSpringBootProperties;
import org.keycloak.representations.idm.GroupRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService extends BaseService {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(GroupService.class);

    public GroupService(KeycloakSpringBootProperties properties) {
        super(properties);
    }

    public Result find() {
        Result<List<GroupRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        keycloak = getKeycloakInstance();
        List<GroupRepresentation> list = keycloak.realm(properties.getRealm()).groups().groups();
        result.setData(list);
        return result;
    }

    public Result findByName(final String name) {
        Result<GroupRepresentation> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        keycloak = getKeycloakInstance();
        GroupRepresentation groupRepresentation = keycloak.realm(properties.getRealm()).groups().group(name).toRepresentation();
        result.setData(groupRepresentation);
        return result;
    }

}
