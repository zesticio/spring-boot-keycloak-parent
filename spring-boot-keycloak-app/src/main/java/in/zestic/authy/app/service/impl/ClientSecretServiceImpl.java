package in.zestic.authy.app.service.impl;

import in.zestic.authy.app.config.KeycloakProperties;
import in.zestic.authy.app.service.BaseService;
import in.zestic.authy.app.service.ClientSecretService;
import in.zestic.common.entity.Result;
import in.zestic.common.security.session.Session;
import in.zestic.common.util.HTTPErrorCodes;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.ClientRepresentation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClientSecretServiceImpl extends BaseService implements ClientSecretService {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ClientSecretServiceImpl.class);

    public ClientSecretServiceImpl(KeycloakProperties properties) {
        super(properties);
    }

    public Result create() {
        Result<List<ClientRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        Keycloak keycloak = (Keycloak) this.session.getClient();
        return result;
    }

    public Result findById() {
        Result<List<ClientRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        Keycloak keycloak = (Keycloak) this.session.getClient();
        return result;
    }
}
