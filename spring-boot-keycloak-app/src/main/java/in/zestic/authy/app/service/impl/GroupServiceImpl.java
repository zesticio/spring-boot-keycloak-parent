package in.zestic.authy.app.service.impl;

import in.zestic.authy.app.config.KeycloakProperties;
import in.zestic.authy.app.service.BaseService;
import in.zestic.authy.app.service.GroupService;
import in.zestic.common.entity.Result;
import in.zestic.common.util.HTTPErrorCodes;
import org.keycloak.representations.idm.GroupRepresentation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl extends BaseService implements GroupService {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(GroupServiceImpl.class);

    public GroupServiceImpl(KeycloakProperties properties) {
        super(properties);
    }

    public Result create() {
        Result<List<GroupRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }

    public Result find() {
        Result<List<GroupRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }

    public Result count() {
        Result<List<GroupRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }

    public Result findById(final String userId) {
        Result<GroupRepresentation> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }

    public Result update(final String userId) {
        Result<List<GroupRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }

    public Result delete(final String userId) {
        Result<List<GroupRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }

    /**
     * return list of all members part of this group
     *
     * @return Result
     */
    public Result members() {
        Result<List<GroupRepresentation>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }

}
