package in.zestic.authy.app.service.impl;

import in.zestic.authy.app.config.KeycloakProperties;
import in.zestic.authy.app.service.BaseService;
import in.zestic.authy.app.service.RealmAdminEventService;
import in.zestic.common.entity.Result;
import in.zestic.common.util.HTTPErrorCodes;
import org.keycloak.representations.idm.GroupRepresentation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealmAdminEventServiceImpl extends BaseService implements RealmAdminEventService {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(RealmAdminEventServiceImpl.class);

    public RealmAdminEventServiceImpl(KeycloakProperties properties) {
        super(properties);
    }

    /**
     * Get admin events Returns all admin events, or filters events based on URL query parameters listed here
     *
     * @return
     */
    public Result find() {
        Result<List<GroupRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }

    public Result delete() {
        Result<List<GroupRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }
}
