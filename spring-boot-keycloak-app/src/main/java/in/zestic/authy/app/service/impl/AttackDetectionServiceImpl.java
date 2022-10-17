package in.zestic.authy.app.service.impl;

import in.zestic.authy.app.config.KeycloakProperties;
import in.zestic.authy.app.service.AttackDetectionService;
import in.zestic.authy.app.service.BaseService;
import in.zestic.common.entity.Result;
import in.zestic.common.util.HTTPErrorCodes;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.AttackDetectionResource;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AttackDetectionServiceImpl extends BaseService implements AttackDetectionService {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(AttackDetectionServiceImpl.class);

    public AttackDetectionServiceImpl(KeycloakProperties properties) {
        super(properties);
    }

    public Result delete() {
        Result<Map<String, Object>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        AttackDetectionResource resource = getResource();
        if (resource != null) {
            resource.clearAllBruteForce();
            result.setMessage("Cleared all login failures");
        } else {
            result.setCode(HTTPErrorCodes.INTERNAL_SERVER_ERROR.getCode());
            result.setMessage(HTTPErrorCodes.INTERNAL_SERVER_ERROR.getMessage());
        }
        return result;
    }

    @Override
    public Result delete(String userId) {
        Result<Void> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        AttackDetectionResource resource = getResource();
        if (resource != null) {
            resource.clearBruteForceForUser(userId);
            result.setMessage("Cleared login failures for user {" + userId + "}");
        } else {
            result.setCode(HTTPErrorCodes.INTERNAL_SERVER_ERROR.getCode());
            result.setMessage(HTTPErrorCodes.INTERNAL_SERVER_ERROR.getMessage());
        }
        return result;
    }

    @Override
    public Result status(String userId) {
        Result<Map<String, Object>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        AttackDetectionResource resource = getResource();
        result.setData(resource != null ? resource.bruteForceUserStatus(userId) : null);
        return result;
    }

    private AttackDetectionResource getResource() {
        Keycloak keycloak = (Keycloak) this.session.getClient();
        return (keycloak != null ? keycloak.realm(properties.getRealm()).attackDetection() : null);
    }
}
