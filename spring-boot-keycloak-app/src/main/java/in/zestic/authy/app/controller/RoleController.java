package in.zestic.authy.app.controller;

import in.zestic.authy.app.service.RoleService;
import in.zestic.common.entity.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.QueryParam;
import java.util.Optional;

@RestController
@RequestMapping(value = "/roles", produces = {MediaType.APPLICATION_JSON_VALUE})
public class RoleController {

    private RoleService service;

    public RoleController(RoleService service) {
        this.service = service;
    }

    /**
     * list all roles and list role by name
     *
     * @return
     */
    @GetMapping(path = "")
    @RolesAllowed({"ROLE_ADMIN"})
    public ResponseEntity<Result> find(@QueryParam("name") Optional<String> name) {
        Result response = null;
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }
}
