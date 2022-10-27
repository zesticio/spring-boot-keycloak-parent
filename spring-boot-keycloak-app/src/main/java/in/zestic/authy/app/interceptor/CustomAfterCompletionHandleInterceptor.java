package in.zestic.authy.app.interceptor;

import in.zestic.authy.app.config.KeycloakProperties;
import in.zestic.common.security.interceptors.AfterCompletionInterceptor;
import in.zestic.common.security.session.Session;
import org.keycloak.admin.client.Keycloak;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class CustomAfterCompletionHandleInterceptor implements AfterCompletionInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(CustomAfterCompletionHandleInterceptor.class.getSimpleName());

    @Resource(name = "session")
    protected Session session;

    protected KeycloakProperties properties;

    public CustomAfterCompletionHandleInterceptor(KeycloakProperties properties) {
        this.properties = properties;
    }

    public void intercept() {
        Keycloak keycloak = (Keycloak) this.session.getClient();
        if (keycloak != null && !keycloak.isClosed())
            keycloak.realm(properties.getRealm()).users().get(session.getUserId()).logout();
    }
}
