package in.zestic.authy.app.service.impl;

import in.zestic.authy.app.config.KeycloakProperties;
import in.zestic.authy.app.service.BaseService;
import in.zestic.authy.app.service.ClientScopeService;
import in.zestic.common.entity.Result;
import in.zestic.common.security.session.Session;
import in.zestic.common.util.HTTPErrorCodes;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.ClientRepresentation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClientScopeServiceImpl extends BaseService implements ClientScopeService {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ClientScopeServiceImpl.class);

    public ClientScopeServiceImpl(KeycloakProperties properties) {
        super(properties);
    }

    public Result create() {
        Result<List<ClientRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }

    public Result find() {
        Result<List<ClientRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }

    public Result findById(String clientScopeId) {
        Result<List<ClientRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }

    public Result update(String clientScopeId) {
        Result<List<ClientRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }

    public Result delete(String clientScopeId) {
        Result<List<ClientRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }
}
