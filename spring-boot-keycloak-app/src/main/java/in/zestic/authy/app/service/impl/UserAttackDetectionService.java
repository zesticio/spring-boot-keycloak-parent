package in.zestic.authy.app.service.impl;

import in.zestic.authy.app.config.KeycloakProperties;
import in.zestic.common.entity.Result;
import in.zestic.common.security.Session;
import in.zestic.common.util.HTTPErrorCodes;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.ClientRepresentation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserAttackDetectionService {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(UserAttackDetectionService.class);

    @Resource(name = "session")
    private Session session;
    protected final KeycloakProperties properties;

    public UserAttackDetectionService(KeycloakProperties properties) {
        this.properties = properties;
    }

    /**
     * Get status of a username in brute force detection
     *
     * @return
     */
    public Result findById(String id) {
        Result<List<ClientRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        Keycloak keycloak = (Keycloak) this.session.getClient();
        return result;
    }

    /**
     * Clear any user login failures for the user This can release temporary disabled user
     *
     * @param id
     * @return
     */
    public Result delete(String id) {
        Result<List<ClientRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        Keycloak keycloak = (Keycloak) this.session.getClient();
        return result;
    }
}
