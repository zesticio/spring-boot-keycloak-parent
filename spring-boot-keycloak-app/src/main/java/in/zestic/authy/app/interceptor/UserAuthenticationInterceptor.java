package in.zestic.authy.app.interceptor;

import in.zestic.authy.app.config.KeycloakProperties;
import in.zestic.authy.app.constant.KeycloakError;
import in.zestic.authy.app.service.impl.UserServiceImpl;
import in.zestic.common.jwt.JWT;
import in.zestic.common.jwt.JWTPayload;
import in.zestic.common.security.Session;
import in.zestic.common.security.service.UserAuthentication;
import in.zestic.common.util.StringUtil;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.token.TokenManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserAuthenticationInterceptor implements UserAuthentication {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource(name = "session")
    private Session session;
    private KeycloakProperties properties;

    public UserAuthenticationInterceptor(KeycloakProperties properties) {
        this.properties = properties;
    }

    @Override
    public Session authenticate(String name, String password) throws RuntimeException {
        Keycloak keycloak = KeycloakBuilder.builder() //
                .serverUrl(this.properties.getAuthServerUrl()) //
                .realm(this.properties.getRealm()) //
                .username(name)
                .password(password)
                .clientId(this.properties.getResourceName()) //
                .clientSecret((String) this.properties.getResourceSecret()) //
                .resteasyClient(new ResteasyClientBuilder()
                        .connectionPoolSize(this.properties.getConnectionPoolSize())
                        .build())
                .build();
        RealmResource realmResource = keycloak.realm(this.properties.getRealm());
        try {
            TokenManager tokenManager = keycloak.tokenManager();
            logger.info("error " + tokenManager.getAccessToken().getError());
            logger.info("description " + tokenManager.getAccessToken().getErrorDescription());
            logger.info("access token " + tokenManager.getAccessTokenString());
            logger.info("token " + tokenManager.getAccessToken().getToken());
            logger.info("id token " + tokenManager.getAccessToken().getIdToken());
            logger.info("token type " + tokenManager.getAccessToken().getTokenType());
            logger.info("expires in " + tokenManager.getAccessToken().getExpiresIn());
            logger.info("session state " + tokenManager.getAccessToken().getSessionState());
            logger.info("refresh expires in " + tokenManager.getAccessToken().getRefreshExpiresIn());
            logger.info("scope " + tokenManager.getAccessToken().getScope());
            logger.info("claims " + StringUtil.toString(tokenManager.getAccessToken().getOtherClaims()));

            JWT jwt = new JWT(tokenManager.getAccessTokenString());
            JWTPayload payload = jwt.getPayload();
            session.setUserDetails(User.withUsername(payload.getEmail())
                    .authorities(String.join(", ", payload.getRealmAccess().getRoles()))
                    .build());
        } catch (Exception ex) {
            logger.info(ex.getMessage());
            session.setErrorCode(KeycloakError.KEYCLOAK_UNAUTHORIZED.getCode());
            session.setErrorMessage(KeycloakError.KEYCLOAK_UNAUTHORIZED.getMessage());
        }
        return session;
    }

    @Override
    public Session authenticate(String name) throws RuntimeException {
        return null;
    }
}
