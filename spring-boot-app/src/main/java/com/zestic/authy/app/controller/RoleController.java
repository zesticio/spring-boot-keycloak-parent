package com.zestic.authy.app.controller;

import com.zestic.authy.app.service.RoleService;
import com.zestic.authy.app.service.UserService;
import com.zestic.authy.app.validator.UserValidator;
import com.zestic.authy.keycloak.entity.User;
import com.zestic.common.entity.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.QueryParam;
import java.util.Optional;

@RestController
@RequestMapping(value = "/roles", produces = {MediaType.APPLICATION_JSON_VALUE})
@Api(value = "", description = "", tags = {"roles"})
public class RoleController {

    private RoleService service;

    public RoleController(RoleService service) {
        this.service = service;
    }

    /**
     * list all roles and list role by name
     *
     * @return
     */
    @GetMapping(path = "")
    @ApiOperation(value = "", notes = "")
    @RolesAllowed({"ROLE_ADMIN"})
    public ResponseEntity<Result> find(@QueryParam("name") Optional<String> name) {
        Result response;
        if (name.isEmpty())
            response = service.find();
        else
            response = service.findByName(name.get());
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }
}
