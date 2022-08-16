package com.zestic.authy.app.service;

import com.zestic.authy.keycloak.entity.User;
import com.zestic.common.entity.Result;
import com.zestic.common.utils.HTTPErrorCodes;
import org.keycloak.adapters.springboot.KeycloakSpringBootProperties;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.GroupResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.GroupRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.*;

@Service
public class UserService extends BaseService {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(UserService.class);

    public UserService(KeycloakSpringBootProperties properties) {
        super(properties);
    }

    public Result find(Optional<String> name) {
        Result<List<UserRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        keycloak = getKeycloakInstance();
        List<UserRepresentation> list = null;
        if (!name.isPresent())
            list = keycloak.realm(properties.getRealm()).users().list();
        else
            list = keycloak.realm(properties.getRealm()).users().search(name.get());
        result.setData(list);
        return result;
    }

    public Result findById(String id) {
        Result<UserRepresentation> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        Keycloak keycloak = getKeycloakInstance();
        UserResource user = keycloak.realm(properties.getRealm()).users().get(id);
        result.setData(user.toRepresentation());
        return result;
    }

    public Result create(User user) {
        Result<User> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");

        keycloak = getKeycloakInstance();

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
        keycloak = getKeycloakInstance();
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

    public Result resetPassword(String id) {
        Result<User> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        keycloak = getKeycloakInstance();
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

    public Result logout(String id) {
        Result<User> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        keycloak = getKeycloakInstance();
        keycloak.realm(properties.getRealm()).users().get(id).logout();
        return result;
    }

    public Result assignRole(String id) {
        Result<User> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        keycloak = getKeycloakInstance();
        return result;
    }
}