package in.zestic.authy.app.service.impl;

import in.zestic.authy.app.config.KeycloakProperties;
import in.zestic.authy.app.service.BaseService;
import in.zestic.authy.app.service.GroupChildrenService;
import in.zestic.authy.app.service.GroupService;
import in.zestic.common.entity.Result;
import in.zestic.common.util.HTTPErrorCodes;
import org.keycloak.representations.idm.GroupRepresentation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupChildrenServiceImpl extends BaseService implements GroupChildrenService {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(GroupChildrenServiceImpl.class);

    public GroupChildrenServiceImpl(KeycloakProperties properties) {
        super(properties);
    }

    public Result create() {
        Result<List<GroupRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }
}
