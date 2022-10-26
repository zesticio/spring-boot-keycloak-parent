package in.zestic.authy.app.controller;

import in.zestic.authy.app.service.RealmService;
import in.zestic.authy.app.validator.ClientValidation;
import in.zestic.authy.keycloak.api.entity.Realm;
import in.zestic.common.entity.Result;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/realms", produces = {MediaType.APPLICATION_JSON_VALUE})
public class RealmController {

    private RealmService service;

    public RealmController(RealmService service) {
        this.service = service;
    }

    @ApiOperation(value = "Find all realms", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Unauthorized")
    })
    @GetMapping(path = "")
    public ResponseEntity<Result> find() {
        Result response = service.find();
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }

    @ApiOperation(value = "Create a new realm", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Realm created"),
            @ApiResponse(code = 401, message = "Unauthorized")
    })
    @PostMapping(path = "")
    public ResponseEntity<Result> create(@ClientValidation @RequestBody Realm realm) {
        Result response = service.create(realm);
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }

    @ApiOperation(value = "Update realm", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Unauthorized")
    })
    @PutMapping(path = "/{id}")
    public ResponseEntity<Result> update(@PathVariable(value = "id") String id) {
        Result response = service.update(id);
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }

    @ApiOperation(value = "Delete realm", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Unauthorized")
    })
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Result> delete(@PathVariable(value = "id") String id) {
        Result response = service.delete(id);
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }
}
