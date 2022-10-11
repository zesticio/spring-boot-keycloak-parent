package in.zestic.authy.app.service.impl;

import in.zestic.authy.app.config.KeycloakProperties;
import in.zestic.authy.app.service.BaseService;
import in.zestic.authy.app.service.UserService;
import in.zestic.authy.keycloak.api.entity.User;
import in.zestic.common.entity.Result;
import in.zestic.common.util.HTTPErrorCodes;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.GroupRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.*;

@Service
public class UserServiceImpl extends BaseService implements UserService {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(UserServiceImpl.class);

    protected final KeycloakProperties properties;

    public UserServiceImpl(KeycloakProperties properties) {
        this.properties = properties;
    }

    public Result find(Optional<String> name) {
        Result<List<UserRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
//        Keycloak keycloak = this.session.getKeycloak();
//        List<UserRepresentation> list = null;
//        if (!name.isPresent())
//            list = keycloak.realm(properties.getRealm()).users().list();
//        else
//            list = keycloak.realm(properties.getRealm()).users().search(name.get());
//        result.setData(list);
        return result;
    }

    public Result findById(String id) {
        Result<UserRepresentation> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        UserResource user = keycloak.realm(properties.getRealm()).users().get(id);
        result.setData(user.toRepresentation());
        return result;
    }

    public Result create(User user) {
        Result<User> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");

        UserRepresentation ur = new UserRepresentation();
        ur.setEnabled(true);
        ur.setUsername(user.getUsername());
        ur.setFirstName(user.getFirstName());
        ur.setLastName(user.getLastName());
        ur.setEmail(user.getEmail());
        List<CredentialRepresentation> credentials = new ArrayList<>();
        CredentialRepresentation credential = new CredentialRepresentation();
        credential.setTemporary(Boolean.FALSE);
        credential.setType(CredentialRepresentation.PASSWORD);
        //TODO Passport
        credential.setValue("");
        ur.setCredentials(credentials);
        ur.setAttributes(Collections.singletonMap("origin", Arrays.asList("demo")));

        realmResource = keycloak.realm(properties.getRealm());
        UsersResource usersResource = realmResource.users();
        Response response = usersResource.create(ur);
        System.out.printf("Response : %s %s%n", response.getStatus(), response.getStatusInfo());
        System.out.println(response.getLocation());
        return result;
    }

    public Result update(String id, Optional<String> group, Optional<String> role) {
        Result<User> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        if (group.isPresent()) {
            keycloak.realm(properties.getRealm())
                    .users()
                    .get(id)
                    .joinGroup(group.get());
        } else {
            final UserResource userResource = keycloak.realm(properties.getRealm()).users().get(id);
            UserRepresentation userRepresentation = userResource.toRepresentation();
            //TODO update user data
            userResource.update(userRepresentation);
        }
        return result;
    }

    /**
     * Set up a new password for the user.
     * @param id
     * @return
     */
    public Result resetPassword(String id) {
        Result<User> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        final UserResource userResource = keycloak.realm(properties.getRealm()).users().get(id);
        UserRepresentation userRepresentation = userResource.toRepresentation();

        CredentialRepresentation credential = new CredentialRepresentation();
        credential.setTemporary(false);
        credential.setType(CredentialRepresentation.PASSWORD);
        //TODO update password
        credential.setValue("password");

        userResource.resetPassword(credential);
        return result;
    }

    /**
     * Remove all user sessions associated with the user Also send notification to all clients that have an admin URL to invalidate the sessions for the particular user.
     * @param id
     * @return
     */
    public Result logout(String id) {
        Result<User> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        keycloak.realm(properties.getRealm()).users().get(id).logout();
        return result;
    }

    public Result assignRole(String id) {
        Result<User> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }

    public Result count() {
        Result<List<RoleRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }

    public Result profile() {
        Result<List<RoleRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }

    public Result delete() {
        Result<List<GroupRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }

    /**
     * Impersonate the user
     * @return
     */
    public Result impersonate() {
        Result<List<GroupRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }

    /**
     * Send an email-verification email to the user An email contains a link the user can click to verify their email address.
     * @return
     */
    public Result sendVerifyEmail() {
        Result<List<GroupRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }
}
