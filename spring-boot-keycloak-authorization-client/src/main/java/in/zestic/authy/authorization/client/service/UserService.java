package in.zestic.authy.authorization.client.service;

import in.zestic.common.entity.Result;
import in.zestic.common.util.HTTPErrorCodes;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(UserService.class);

    public UserService() {
    }

    public Result find() {
        Result<String> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }
}
