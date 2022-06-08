package com.zestic.authy.app.service;

import com.zestic.authy.keycloak.entity.User;
import com.zestic.common.entity.Result;
import com.zestic.common.utils.HTTPErrorCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ClientService.class);

    @Autowired
    public ClientService() {
    }

    public Result handleFind() {
        Result<User> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }

    public Result handleCreate() {
        Result<User> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }

    public Result handleUpdate(String id) {
        Result<User> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }

    public Result handleFindById(String id) {
        Result<User> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), "");
        return result;
    }
}
