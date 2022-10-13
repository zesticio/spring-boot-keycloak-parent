package in.zestic.authy.app.service.impl;

import in.zestic.authy.app.config.KeycloakProperties;
import in.zestic.authy.app.service.BaseService;
import in.zestic.common.entity.Result;
import in.zestic.common.util.HTTPErrorCodes;
import org.keycloak.representations.idm.GroupRepresentation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFederatedIdentity extends BaseService {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(UserFederatedIdentity.class);

    public UserFederatedIdentity(KeycloakProperties properties) {
        super(properties);
    }

    /**
     * Get social logins associated with the user
     * @return
     */
    public Result find() {
        Result<List<GroupRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }

    /**
     * Add a social login provider to the user
     * @return
     */
    public Result add() {
        Result<List<GroupRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }

    /**
     * Remove a social login provider from user
     * @return
     */
    public Result delete() {
        Result<List<GroupRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }

}
