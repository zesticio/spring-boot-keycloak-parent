package in.zestic.authy.app.controller;

import in.zestic.authy.app.service.ClientService;
import in.zestic.authy.app.validator.ClientValidation;
import in.zestic.authy.keycloak.demo.entity.Client;
import in.zestic.common.entity.Result;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping(value = "/clients", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ClientController {

    private ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    /**
     * @param client Client
     * @return ResponseEntity
     */
    @ApiOperation(value = "Create a new client", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Client created"),
            @ApiResponse(code = 401, message = "Unauthorized")
    })
    @PostMapping(path = "")
    public ResponseEntity<Result> create(@ClientValidation @RequestBody Client client) {
        Result response = service.create(client);
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }

    /**
     * @return ResponseEntity
     */
    @ApiOperation(value = "Find all clients", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Unauthorized")
    })
    @GetMapping(path = "")
    @RolesAllowed({"ROLE_ADMIN"})
    public ResponseEntity<Result> find() {
        Result response = service.find();
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }

    /**
     * @param id String
     * @return ResponseEntity
     */
    @ApiOperation(value = "Find client by id", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Unauthorized")
    })
    @GetMapping(path = "/{id}")
    public ResponseEntity<Result> findById(@PathVariable(value = "id") String id) {
        Result response = service.findById(id);
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }

    /**
     * @param id String
     * @return ResponseEntity
     */
    @ApiOperation(value = "Update client", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Unauthorized")
    })
    @PutMapping(path = "/{id}")
    public ResponseEntity<Result> update(@PathVariable(value = "id") String id) {
        Result response = service.update(id);
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }

    /**
     * @param id String
     * @return ResponseEntity
     */
    @ApiOperation(value = "Update client", response = ResponseEntity.class)
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
