package in.zestic.authy.app.service.impl;

import in.zestic.authy.app.config.KeycloakProperties;
import in.zestic.common.entity.Result;
import in.zestic.common.security.session.Session;
import in.zestic.common.util.HTTPErrorCodes;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.ClientsResource;
import org.keycloak.representations.idm.ClientRepresentation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClientRoleMapping {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ClientRoleMapping.class);

    @Resource(name = "session")
    private Session session;
    protected final KeycloakProperties properties;

    public ClientRoleMapping(KeycloakProperties properties) {
        this.properties = properties;
    }

    /**
     * Add client-level roles to the user role mapping
     * @param groupId
     * @param clientId
     * @return
     */
    public Result create(String groupId, String clientId) {
        Result<List<ClientRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        Keycloak keycloak = (Keycloak) this.session.getClient();
        return result;
    }

    /**
     * Get client-level role mappings for the user, and the app
     * @return
     */
    public Result find() {
        Result<List<ClientRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        Keycloak keycloak = (Keycloak) this.session.getClient();
        ClientsResource resource = keycloak.realm(properties.getRealm()).clients();
        if (resource != null) {
            result.setData(resource.findAll());
        }
        return result;
    }

    public Result update(String id) {
        Result<List<ClientRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        Keycloak keycloak = (Keycloak) this.session.getClient();
        return result;
    }

    /**
     * Delete client-level roles from user role mapping
     * @param id
     * @return
     */
    public Result delete(String id) {
        Result<List<ClientRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        Keycloak keycloak = (Keycloak) this.session.getClient();
        return result;
    }

    /**
     * Get available client-level roles that can be mapped to the user
     * @param id
     * @return
     */
    public Result findAvailableRoles(String id) {
        Result<List<ClientRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        Keycloak keycloak = (Keycloak) this.session.getClient();
        return result;
    }

}
