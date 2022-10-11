package in.zestic.authy.app.service.impl;

import in.zestic.authy.app.config.KeycloakProperties;
import in.zestic.authy.app.service.BaseService;
import in.zestic.common.entity.Result;
import in.zestic.common.util.HTTPErrorCodes;
import org.keycloak.representations.idm.RoleRepresentation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService extends BaseService {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(RoleService.class);

    protected final KeycloakProperties properties;

    public RoleService(KeycloakProperties properties) {
        this.properties = properties;
    }

    public Result create() {
        Result<List<RoleRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }

    public Result find() {
        Result<List<RoleRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }

    public Result findByName(final String name) {
        Result<RoleRepresentation> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        RoleRepresentation role = keycloak.realm(properties.getRealm()).roles().get(name).toRepresentation();
        result.setData(role);
        return result;
    }

    public Result updateByName(final String name) {
        Result<RoleRepresentation> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }

    public Result delete() {
        Result<List<RoleRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }

    /**
     * Returns a stream of users that have the specified role name.
     * @return
     */
    public Result users() {
        Result<List<RoleRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }

}
