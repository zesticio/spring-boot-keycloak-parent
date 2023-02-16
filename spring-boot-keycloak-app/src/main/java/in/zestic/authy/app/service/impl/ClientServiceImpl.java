package in.zestic.authy.app.service.impl;

import in.zestic.authy.app.config.KeycloakProperties;
import in.zestic.authy.app.service.BaseService;
import in.zestic.authy.app.service.ClientService;
import in.zestic.authy.keycloak.demo.entity.Client;
import in.zestic.common.entity.Result;
import in.zestic.common.util.HTTPErrorCodes;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.ClientsResource;
import org.keycloak.representations.idm.ClientRepresentation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl extends BaseService implements ClientService {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ClientServiceImpl.class);

    public ClientServiceImpl(KeycloakProperties properties) {
        super(properties);
    }

    public Result create(Client client) {
        Result<List<ClientRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        ClientsResource resource = getResource();
        resource.create(createClientRepresentation(client));
        return result;
    }

    public Result find() {
        Result<List<ClientRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }

    public Result findById(String id) {
        Result<List<ClientRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }

    public Result update(String id) {
        Result<List<ClientRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }

    public Result delete(String id) {
        Result<List<ClientRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }

    private ClientRepresentation createClientRepresentation(Client client) {
        ClientRepresentation clientRepresentation = new ClientRepresentation();
        return clientRepresentation;
    }

    private ClientsResource getResource() {
        Keycloak keycloak = (Keycloak) this.session.getClient();
        return (keycloak != null ? keycloak.realm(properties.getRealm()).clients() : null);
    }
}
