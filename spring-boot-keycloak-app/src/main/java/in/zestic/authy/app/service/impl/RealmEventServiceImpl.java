package in.zestic.authy.app.service.impl;

import in.zestic.authy.app.config.KeycloakProperties;
import in.zestic.authy.app.service.BaseService;
import in.zestic.authy.app.service.RealmEventService;
import in.zestic.common.entity.Result;
import in.zestic.common.util.HTTPErrorCodes;
import org.keycloak.representations.idm.GroupRepresentation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealmEventServiceImpl extends BaseService implements RealmEventService {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(RealmEventServiceImpl.class);

    public RealmEventServiceImpl(KeycloakProperties properties) {
        super(properties);
    }

    /**
     * Get admin events Returns all admin events, or filters events based on URL query parameters listed here
     * @return Result
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
