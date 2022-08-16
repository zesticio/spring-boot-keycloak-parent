package com.zestic.authy.app.controller;

import com.zestic.authy.app.service.ClientService;
import com.zestic.authy.app.service.RoleService;
import com.zestic.common.entity.Result;
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
@RequestMapping(value = "/clients", produces = {MediaType.APPLICATION_JSON_VALUE})
@Api(value = "", description = "", tags = {"clients"})
public class ClientController {

    private ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping(path = "")
    @ApiOperation(value = "", notes = "")
    @RolesAllowed({"ROLE_ADMIN"})
    public ResponseEntity<Result> find() {
        Result response = service.find();
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }
}
