package com.zestic.authy.app.service;

import com.zestic.common.entity.Result;
import com.zestic.common.utils.HTTPErrorCodes;
import org.keycloak.adapters.springboot.KeycloakSpringBootProperties;
import org.keycloak.representations.idm.ClientRepresentation;
import org.keycloak.representations.idm.GroupRepresentation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService extends BaseService {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ClientService.class);

    public ClientService(KeycloakSpringBootProperties properties) {
        super(properties);
    }

    public Result find() {
        Result<List<ClientRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        keycloak = getKeycloakInstance();
        List<ClientRepresentation> list = keycloak.realm(properties.getRealm()).clients().findAll();
        result.setData(list);
        return result;
    }
}
