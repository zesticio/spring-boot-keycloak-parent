package in.zestic.authy.authorization.client.controller;

import in.zestic.authy.authorization.client.service.UserService;
import in.zestic.common.entity.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping(value = "/users", produces = {MediaType.APPLICATION_JSON_VALUE})
@Api(value = "", description = "", tags = {"clients"})
public class UserController {

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @ApiOperation(value = "ErrorReport REST Service",
            notes = "This sends an email notification based on the criteria added",
            response = Result.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = ""),
            @ApiResponse(code = 400, message = "", response = Result.class),
            @ApiResponse(code = 500, message = "", response = Result.class)})
    @GetMapping(path = "")
    @RolesAllowed({"ROLE_ADMIN"})
    public ResponseEntity<Result> find() {
        Result response = service.find();
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }
}
