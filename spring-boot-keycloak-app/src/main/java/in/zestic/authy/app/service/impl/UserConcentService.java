package in.zestic.authy.app.service.impl;

import in.zestic.authy.app.config.KeycloakProperties;
import in.zestic.authy.app.service.BaseService;
import in.zestic.authy.app.service.UserService;
import in.zestic.authy.keycloak.api.entity.User;
import in.zestic.common.entity.Result;
import in.zestic.common.util.HTTPErrorCodes;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.GroupRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.*;

@Service
public class UserConcentService extends BaseService {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(UserConcentService.class);

    public UserConcentService(KeycloakProperties properties) {
        super(properties);
    }

    /**
     * Get consents granted by the user
     *
     * @return
     */
    public Result find() {
        Result<List<GroupRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }

    /**
     * Revoke consent and offline tokens for particular client from user
     *
     * @return
     */
    public Result revoke() {
        Result<List<GroupRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }

}
