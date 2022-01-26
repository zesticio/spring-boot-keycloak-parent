package com.zestic.authy.app.service;

import com.zestic.authy.app.entity.user.User;
import com.zestic.common.entity.Result;
import com.zestic.log.Log;
import com.zestic.log.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RealmService {

    private Log logger = LogFactory.get();

    @Autowired
    public RealmService() {
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
