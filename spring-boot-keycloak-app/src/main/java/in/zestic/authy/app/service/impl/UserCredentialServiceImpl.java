package in.zestic.authy.app.service.impl;

import in.zestic.authy.app.config.KeycloakProperties;
import in.zestic.authy.app.service.BaseService;
import in.zestic.authy.app.service.UserConsentService;
import in.zestic.authy.app.service.UserCredentialService;
import in.zestic.common.entity.Result;
import in.zestic.common.util.HTTPErrorCodes;
import org.keycloak.representations.idm.GroupRepresentation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCredentialServiceImpl extends BaseService implements UserCredentialService {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(UserCredentialServiceImpl.class);

    public UserCredentialServiceImpl(KeycloakProperties properties) {
        super(properties);
    }

    public Result find() {
        Result<List<GroupRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }

    /**
     * Remove a credential for a user
     * @return Result
     */
    public Result delete(String credentialId) {
        Result<List<GroupRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }

}
