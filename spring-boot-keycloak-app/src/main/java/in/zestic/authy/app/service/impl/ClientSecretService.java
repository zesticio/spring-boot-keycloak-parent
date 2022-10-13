package in.zestic.authy.app.service.impl;

import in.zestic.authy.app.config.KeycloakProperties;
import in.zestic.common.entity.Result;
import in.zestic.common.security.session.Session;
import in.zestic.common.util.HTTPErrorCodes;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.ClientRepresentation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClientSecretService {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ClientSecretService.class);

    @Resource(name = "session")
    private Session session;
    protected final KeycloakProperties properties;

    public ClientSecretService(KeycloakProperties properties) {
        this.properties = properties;
    }

    public Result create(String id) {
        Result<List<ClientRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        Keycloak keycloak = (Keycloak) this.session.getClient();
        return result;
    }

    public Result findById(String id) {
        Result<List<ClientRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        Keycloak keycloak = (Keycloak) this.session.getClient();
        return result;
    }
}
