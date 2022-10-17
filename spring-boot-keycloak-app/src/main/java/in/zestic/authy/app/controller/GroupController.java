package in.zestic.authy.app.controller;

import in.zestic.authy.app.service.GroupService;
import in.zestic.common.entity.Result;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/groups", produces = {MediaType.APPLICATION_JSON_VALUE})
public class GroupController {

    private GroupService service;

    public GroupController(GroupService service) {
        this.service = service;
    }

    /**
     * @return ResponseEntity
     */
    @ApiOperation(value = "Create a new group", response = ResponseEntity.class)
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
    @ApiOperation(value = "Get group hierarchy.", response = ResponseEntity.class)
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
    @ApiOperation(value = "Returns the groups counts", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Client created"),
            @ApiResponse(code = 401, message = "Unauthorized")
    })
    @GetMapping(path = "/count")
    public ResponseEntity<Result> count() {
        Result response = service.count();
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }

    /**
     * @param id String
     * @return ResponseEntity
     */
    @ApiOperation(value = "Get group into by id", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Client created"),
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
    @ApiOperation(value = "Get group into by id", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Client created"),
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
    @ApiOperation(value = "Get group into by id", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Client created"),
            @ApiResponse(code = 401, message = "Unauthorized")
    })
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Result> delete(@PathVariable(value = "id") String id) {
        Result response = service.delete(id);
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }
}
