package in.zestic.authy.app.controller;

import in.zestic.authy.app.service.ClientScopeService;
import in.zestic.authy.app.service.ClientSecretService;
import in.zestic.common.entity.Result;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "clients/{id}/client-scopes", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ClientSecretController {

    private ClientSecretService service;

    public ClientSecretController(ClientSecretService service) {
        this.service = service;
    }

    /**
     * @return ResponseEntity
     */
    @ApiOperation(value = "Create a new client", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Client created"),
            @ApiResponse(code = 401, message = "Unauthorized")
    })
    @PostMapping(path = "")
    public ResponseEntity<Result> create() {
        Result response = service.create();
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
    public ResponseEntity<Result> findById() {
        Result response = service.findById();
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }
}
