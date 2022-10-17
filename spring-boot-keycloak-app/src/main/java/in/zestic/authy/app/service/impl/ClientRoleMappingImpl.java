package in.zestic.authy.app.service.impl;

import in.zestic.authy.app.config.KeycloakProperties;
import in.zestic.authy.app.service.BaseService;
import in.zestic.authy.app.service.ClientRoleMapping;
import in.zestic.common.entity.Result;
import in.zestic.common.security.session.Session;
import in.zestic.common.util.HTTPErrorCodes;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.ClientsResource;
import org.keycloak.representations.idm.ClientRepresentation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClientRoleMappingImpl extends BaseService implements ClientRoleMapping {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ClientRoleMappingImpl.class);

    public ClientRoleMappingImpl(KeycloakProperties properties) {
        super(properties);
    }

    /**
     * Add client-level roles to the user role mapping
     * @return Result
     */
    public Result create() {
        Result<List<ClientRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }

    /**
     * Get client-level role mappings for the user, and the app
     *
     * @return Result
     */
    public Result find() {
        Result<List<ClientRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }

    public Result update(String userId) {
        Result<List<ClientRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }

    /**
     * Delete client-level roles from user role mapping
     *
     * @param userId String
     * @return Result
     */
    public Result delete(String userId) {
        Result<List<ClientRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }
}
