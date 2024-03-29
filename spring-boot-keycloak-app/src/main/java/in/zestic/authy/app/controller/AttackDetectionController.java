package in.zestic.authy.app.controller;

import in.zestic.authy.app.service.AttackDetectionService;
import in.zestic.common.entity.Result;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/attack-detection/brute-force", produces = {MediaType.APPLICATION_JSON_VALUE})
public class AttackDetectionController {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(AttackDetectionController.class);

    private AttackDetectionService service;

    public AttackDetectionController(AttackDetectionService service) {
        this.service = service;
    }

    /**
     * Only admin should have access to this api
     *
     * @return ResponseEntity
     */
    @ApiOperation(value = "Clear any user login failures for all users This can release temporary disabled users", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Unauthorized")
    })
    @DeleteMapping(path = "")
    public ResponseEntity<Result> delete() {
        Result response = service.delete();
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }

    /**
     * Only admin should have access to this api
     *
     * @param userId User Id
     * @return ResponseEntity
     */
    @ApiOperation(value = "Get status of a user in brute force detection", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Unauthorized")
    })
    @GetMapping(path = "/{userId}")
    public ResponseEntity<Result> status(@PathVariable(value = "userId") String userId) {
        Result response = service.status(userId);
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }

    /**
     * Only admin should have access to this api
     *
     * @param userId User Id
     * @return ResponseEntity
     */
    @ApiOperation(value = "Clear any user login failures for the user This can release temporary disabled user", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Unauthorized")
    })
    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<Result> delete(@PathVariable(value = "userId") String userId) {
        Result response = service.delete(userId);
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }
}
