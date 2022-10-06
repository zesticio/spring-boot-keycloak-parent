package in.zestic.authy.app.service;

import in.zestic.authy.app.config.KeycloakManager;
import in.zestic.authy.app.config.KeycloakProperties;
import in.zestic.springboot.common.entity.Result;
import in.zestic.springboot.common.util.HTTPErrorCodes;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.RoleRepresentation;
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
