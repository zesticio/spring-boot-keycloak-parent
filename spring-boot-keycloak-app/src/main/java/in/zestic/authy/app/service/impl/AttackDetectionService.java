package in.zestic.authy.app.service.impl;

import in.zestic.authy.app.config.KeycloakProperties;
import in.zestic.common.entity.Result;
import in.zestic.common.security.Session;
import in.zestic.common.util.HTTPErrorCodes;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.ClientsResource;
import org.keycloak.representations.idm.ClientRepresentation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AttackDetectionService {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(AttackDetectionService.class);

    @Resource(name = "session")
    private Session session;
    protected final KeycloakProperties properties;

    public AttackDetectionService(KeycloakProperties properties) {
        this.properties = properties;
    }

    /**
     * Clear any user login failures for all users This can release temporary disabled users
     * @return
     */
    public Result delete() {
        Result<List<ClientRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        Keycloak keycloak = (Keycloak) this.session.getClient();
        return result;
    }
}
