package in.zestic.authy.app.controller;

import in.zestic.authy.app.service.RealmAdminEventService;
import in.zestic.authy.app.service.RealmEventService;
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

@RestController
@RequestMapping(value = "/events", produces = {MediaType.APPLICATION_JSON_VALUE})
public class RealmEventController {

    private RealmEventService service;

    public RealmEventController(RealmEventService service) {
        this.service = service;
    }

    /**
     * @return ResponseEntity
     */
    @ApiOperation(value = "Get events Returns all events, or filters them based on URL query parameters listed here", response = ResponseEntity.class)
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
     * @return ResponseEntity
     */
    @ApiOperation(value = "Delete all events", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Client created"),
            @ApiResponse(code = 401, message = "Unauthorized")
    })
    @DeleteMapping(path = "")
    public ResponseEntity<Result> delete() {
        Result response = service.delete();
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }
}
