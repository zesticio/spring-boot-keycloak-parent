package in.zestic.authy.app.controller;

import in.zestic.authy.app.handler.LogoutInvocationHandler;
import in.zestic.authy.app.service.AttackDetectionUserService;
import in.zestic.common.entity.Result;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Proxy;

@RestController
@RequestMapping(value = "/attack-detection/users/brute-force", produces = {MediaType.APPLICATION_JSON_VALUE})
public class AttackDetectionUserController {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(AttackDetectionUserController.class);

    private final AttackDetectionUserService service;

    public AttackDetectionUserController(AttackDetectionUserService service) {
        this.service = (AttackDetectionUserService) Proxy.newProxyInstance(
                LogoutInvocationHandler.class.getClassLoader(),
                new Class[]{AttackDetectionUserService.class},
                new LogoutInvocationHandler(service));
    }

    @ApiOperation(value = "Get status of a logged in user in brute force detection", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Unauthorized")
    })
    @GetMapping(path = "")
    public ResponseEntity<Result> status() {
        Result response = service.status();
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }

    /**
     * Clear login failures
     *
     * @return ResponseEntity
     */
    @ApiOperation(value = "Clear login failures", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Unauthorized")
    })
    @DeleteMapping(path = "")
    public ResponseEntity<Result> delete() {
        Result response = service.delete();
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }

}
