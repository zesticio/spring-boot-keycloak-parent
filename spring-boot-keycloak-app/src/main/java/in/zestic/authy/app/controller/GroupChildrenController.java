package in.zestic.authy.app.controller;

import in.zestic.authy.app.service.GroupChildrenService;
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
@RequestMapping(value = "/groups/{id}/children", produces = {MediaType.APPLICATION_JSON_VALUE})
public class GroupChildrenController {

    private GroupChildrenService service;

    public GroupChildrenController(GroupChildrenService service) {
        this.service = service;
    }

    /**
     * @return ResponseEntity
     */
    @ApiOperation(value = "Set or create child", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Client created"),
            @ApiResponse(code = 401, message = "Unauthorized")
    })
    @PostMapping(path = "")
    public ResponseEntity<Result> create() {
        Result response = service.create();
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }

}
