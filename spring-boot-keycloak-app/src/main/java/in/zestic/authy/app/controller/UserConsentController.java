package in.zestic.authy.app.controller;

import in.zestic.authy.app.service.UserConsentService;
import in.zestic.common.entity.Result;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users/{id}/consents", produces = {MediaType.APPLICATION_JSON_VALUE})
public class UserConsentController {

    private UserConsentService service;

    public UserConsentController(UserConsentService service) {
        this.service = service;
    }

    /**
     * @return ResponseEntity
     */
    @ApiOperation(value = "Get consents granted by the user", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Client created"),
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
    @ApiOperation(value = "Revoke consent and offline tokens for particular client from user", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Client created"),
            @ApiResponse(code = 401, message = "Unauthorized")
    })
    @DeleteMapping(path = "/{clientScopeId}")
    public ResponseEntity<Result> delete(@PathVariable(value = "clientScopeId") String clientScopeId) {
        Result response = service.delete(clientScopeId);
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }
}
