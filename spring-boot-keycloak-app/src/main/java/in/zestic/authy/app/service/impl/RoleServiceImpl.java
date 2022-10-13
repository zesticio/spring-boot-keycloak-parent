package in.zestic.authy.app.service.impl;

import in.zestic.authy.app.config.KeycloakProperties;
import in.zestic.authy.app.service.RoleService;
import in.zestic.common.entity.Result;
import in.zestic.common.security.session.Session;
import in.zestic.common.util.HTTPErrorCodes;
import org.keycloak.representations.idm.RoleRepresentation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(RoleServiceImpl.class);

    @Resource(name = "session")
    private Session session;
    protected final KeycloakProperties properties;

    public RoleServiceImpl(KeycloakProperties properties) {
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
     *
     * @return
     */
    public Result users() {
        Result<List<RoleRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }

}
