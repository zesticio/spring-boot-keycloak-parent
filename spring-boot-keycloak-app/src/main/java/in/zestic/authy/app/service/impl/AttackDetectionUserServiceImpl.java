package in.zestic.authy.app.service.impl;

import in.zestic.authy.app.config.KeycloakProperties;
import in.zestic.authy.app.service.AttackDetectionUserService;
import in.zestic.authy.app.service.BaseService;
import in.zestic.common.entity.Result;
import in.zestic.common.util.HTTPErrorCodes;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.AttackDetectionResource;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AttackDetectionUserServiceImpl extends BaseService implements AttackDetectionUserService {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(AttackDetectionUserServiceImpl.class);

    public AttackDetectionUserServiceImpl(KeycloakProperties properties) {
        super(properties);
    }

    @Override
    public Result status() {
        Result<Map<String, Object>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        AttackDetectionResource resource = getResource();
        result.setData(resource != null ? resource.bruteForceUserStatus(session.getUserId()) : null);
        return result;
    }

    @Override
    public Result delete() {
        Result<Void> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), HTTPErrorCodes.SUCCESS.getMessage());
        AttackDetectionResource resource = getResource();
        if (resource != null) {
            resource.clearBruteForceForUser(session.getUserId());
            result.setMessage("Cleared login failures");
        } else {
            result.setCode(HTTPErrorCodes.INTERNAL_SERVER_ERROR.getCode());
            result.setMessage(HTTPErrorCodes.INTERNAL_SERVER_ERROR.getMessage());
        }
        return result;
    }

    private AttackDetectionResource getResource() {
        Keycloak keycloak = (Keycloak) this.session.getClient();
        return (keycloak != null ? keycloak.realm(properties.getRealm()).attackDetection() : null);
    }
}
