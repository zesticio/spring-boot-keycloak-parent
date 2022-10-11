package in.zestic.authy.app.service;

import in.zestic.authy.app.config.KeycloakProperties;
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

    public Result find() {
        Result<List<RoleRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
//        Keycloak keycloak = this.session.getKeycloak();
//        List<RoleRepresentation> list = keycloak.realm(properties.getRealm()).roles().list();
//        result.setData(list);
        return result;
    }

    public Result findByName(final String name) {
        Result<RoleRepresentation> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        RoleRepresentation role = keycloak.realm(properties.getRealm()).roles().get(name).toRepresentation();
        result.setData(role);
        return result;
    }
}
