package in.zestic.authy.app.service;

import in.zestic.authy.app.config.KeycloakManager;
import in.zestic.authy.app.config.KeycloakProperties;
import in.zestic.springboot.common.entity.Result;
import in.zestic.springboot.common.util.HTTPErrorCodes;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.ClientsResource;
import org.keycloak.representations.idm.ClientRepresentation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ClientService.class);

    protected final KeycloakProperties properties;
    protected final KeycloakManager manager;

    public ClientService(KeycloakProperties properties, KeycloakManager manager) {
        this.properties = properties;
        this.manager = manager;
    }

    public Result find() {
        Result<List<ClientRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        Keycloak keycloak = this.manager.getKeycloak();
        ClientsResource resource = keycloak.realm(properties.getRealm()).clients();
        if (resource != null) {
//            List<ClientRepresentation> list = resource.findAll();
            result.setData(resource.findAll());
        }
        return result;
    }
}
