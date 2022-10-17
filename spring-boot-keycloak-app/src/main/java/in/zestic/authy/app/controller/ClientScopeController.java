package in.zestic.authy.app.controller;

import in.zestic.authy.app.service.ClientRoleMapping;
import in.zestic.authy.app.service.ClientScopeService;
import in.zestic.common.entity.Result;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/client-scopes", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ClientScopeController {

    private ClientScopeService service;

    public ClientScopeController(ClientScopeService service) {
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
    public ResponseEntity<Result> find() {
        Result response = service.find();
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }

    /**
     * @param clientScopeId String
     * @return ResponseEntity
     */
    @ApiOperation(value = "Find client scope by id", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Unauthorized")
    })
    @GetMapping(path = "/{clientScopeId}")
    public ResponseEntity<Result> findById(@PathVariable(value = "clientScopeId") String clientScopeId) {
        Result response = service.findById(clientScopeId);
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }

    /**
     * @param clientScopeId String
     * @return ResponseEntity
     */
    @ApiOperation(value = "Update client scope", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Unauthorized")
    })
    @PutMapping(path = "/{clientScopeId}")
    public ResponseEntity<Result> update(@PathVariable(value = "clientScopeId") String clientScopeId) {
        Result response = service.update(clientScopeId);
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }

    /**
     * @param clientScopeId String
     * @return ResponseEntity
     */
    @ApiOperation(value = "Delete client scope", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Unauthorized")
    })
    @DeleteMapping(path = "/{clientScopeId}")
    public ResponseEntity<Result> delete(@PathVariable(value = "clientScopeId") String clientScopeId) {
        Result response = service.delete(clientScopeId);
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }
}
