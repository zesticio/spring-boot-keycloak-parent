package com.zestic.authy.app.service;

import com.zestic.authy.app.entity.user.User;
import com.zestic.common.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.LogManager.getLogger(UserService.class);

    @Autowired
    public UserService() {
    }

    public Result handleFind() {
        Result<User> result = new Result();
        return result;
    }

    public Result handleCreate() {
        Result<User> result = new Result();
        return result;
    }

    public Result handleUpdate(String id) {
        Result<User> result = new Result();
        return result;
    }

    public Result handleFindById(String id) {
        Result<User> result = new Result();
        return result;
    }
}
