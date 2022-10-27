package in.zestic.authy.app.service.impl;

import in.zestic.authy.app.config.KeycloakProperties;
import in.zestic.authy.app.service.BaseService;
import in.zestic.authy.app.service.RealmService;
import in.zestic.authy.keycloak.api.entity.Realm;
import in.zestic.authy.keycloak.api.entity.User;
import in.zestic.common.entity.Result;
import in.zestic.common.util.HTTPErrorCodes;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RealmsResource;
import org.keycloak.representations.idm.RealmRepresentation;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RealmServiceImpl extends BaseService implements RealmService {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(RealmServiceImpl.class);

    public RealmServiceImpl(KeycloakProperties properties) {
        super(properties);
    }

    public Result find() {
        Result<List<RealmRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        RealmsResource resource = getResource();
        if (resource != null) {
            result.setData(resource.findAll());
        } else {
            result.setCode(HTTPErrorCodes.INTERNAL_SERVER_ERROR.getCode());
            result.setMessage(HTTPErrorCodes.INTERNAL_SERVER_ERROR.getMessage());
        }
        return result;
    }

    public Result create(Realm realm) {
        Result<User> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        RealmsResource resource = getResource();
        if (resource != null) {
            RealmRepresentation realmRepresentation = new RealmRepresentation();
            realmRepresentation.setId(realm.getName());
            realmRepresentation.setRealm(realm.getName());
            realmRepresentation.setDisplayName(realm.getName());
            realmRepresentation.setEnabled(realm.getEnabled());

            Map<String, String> smtpServer = new HashMap<>();
            smtpServer.put("password", "");
            smtpServer.put("replyToDisplayName", "Administrator");
            smtpServer.put("starttls", "");
            smtpServer.put("auth", "true");
            smtpServer.put("port", "465");
            smtpServer.put("host", "smtppro.zoho.in");
            smtpServer.put("replyTo", "admin@zestic.in");
            smtpServer.put("from", "admin@zestic.in");
            smtpServer.put("fromDisplayName", "Administrator");
            smtpServer.put("ssl", "true");
            smtpServer.put("user", "admin@zestic.in");
            realmRepresentation.setSmtpServer(smtpServer);

            realmRepresentation.setLoginTheme("keycloak");
            realmRepresentation.setAccountTheme("keycloak.v2");
            realmRepresentation.setAdminTheme("keycloak");
            realmRepresentation.setEmailTheme("keycloak");
            realmRepresentation.setInternationalizationEnabled(false);

            realmRepresentation.setRegistrationAllowed(false);
            realmRepresentation.setLoginWithEmailAllowed(true);
            realmRepresentation.setDuplicateEmailsAllowed(false);
            realmRepresentation.setResetPasswordAllowed(false);
            realmRepresentation.setEditUsernameAllowed(true);
            realmRepresentation.setBruteForceProtected(true);

            resource.create(realmRepresentation);
        } else {
            result.setCode(HTTPErrorCodes.INTERNAL_SERVER_ERROR.getCode());
            result.setMessage(HTTPErrorCodes.INTERNAL_SERVER_ERROR.getMessage());
        }
        return result;
    }

    private RealmsResource getResource() {
        Keycloak keycloak = (Keycloak) this.session.getClient();
        return (keycloak != null ? keycloak.realms() : null);
    }

}
