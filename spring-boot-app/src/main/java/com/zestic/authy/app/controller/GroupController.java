package com.zestic.authy.app.controller;

import com.zestic.authy.app.service.RoleService;
import com.zestic.springboot.common.entity.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.QueryParam;
import java.util.Optional;

@RestController
@RequestMapping(value = "/groups", produces = {MediaType.APPLICATION_JSON_VALUE})
@Api(value = "", description = "", tags = {"groups"})
public class GroupController {

    private RoleService service;

    public GroupController(RoleService service) {
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
