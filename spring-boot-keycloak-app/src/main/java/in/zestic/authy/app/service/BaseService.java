package in.zestic.authy.app.service;

import in.zestic.authy.app.config.KeycloakProperties;
import in.zestic.common.security.session.Session;
import org.keycloak.admin.client.Keycloak;

import javax.annotation.Resource;

public class BaseService {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(BaseService.class);

    @Resource(name = "session")
    protected Session session;
    protected KeycloakProperties properties;

    public BaseService(KeycloakProperties properties) {
        this.properties = properties;
    }

    public void logout() {
        Keycloak keycloak = (Keycloak) this.session.getClient();
        keycloak.realm(properties.getRealm()).users().get(session.getUserId()).logout();
    }
}
