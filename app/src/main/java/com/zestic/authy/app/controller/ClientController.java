package com.zestic.authy.app.controller;

import com.zestic.authy.app.service.ClientService;
import com.zestic.common.entity.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping(value = "/clients", produces = {MediaType.APPLICATION_JSON_VALUE})
@Api(value = "", description = "", tags = {"Clients"})
public class ClientController {

    private ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    /**
     * list all users
     *
     * @return
     */
    @GetMapping(path = "")
    @ApiOperation(value = "", notes = "")
    public ResponseEntity<Result> find() {
        Result response = service.handleFind();
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }

    /**
     * Create a new user
     *
     * @return
     */
    @PostMapping(path = "")
    @ApiOperation(value = "", notes = "")
    public ResponseEntity<Result> create() {
        Result response = service.handleCreate();
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }

    /**
     * Update user
     *
     * @param id
     * @return
     */
    @PutMapping(path = "/{id}")
    @ApiOperation(value = "", notes = "")
    public ResponseEntity<Result> update(@PathVariable(value = "id") String id) {
        Result response = service.handleUpdate(id);
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }

    /**
     * Get user by id
     *
     * @param id
     * @return
     */
    @GetMapping(path = "/{id}")
    @ApiOperation(value = "", notes = "")
    public ResponseEntity<Result> findById(@PathVariable(value = "id") String id) {
        Result response = service.handleFindById(id);
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }
}
