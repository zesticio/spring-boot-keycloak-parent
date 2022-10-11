package in.zestic.authy.app.controller;

import in.zestic.authy.app.service.impl.UserServiceImpl;
import in.zestic.authy.app.validator.UserValidator;
import in.zestic.authy.keycloak.api.entity.User;
import in.zestic.common.entity.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.QueryParam;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users", produces = {MediaType.APPLICATION_JSON_VALUE})
public class UserController {

    private UserServiceImpl service;

    public UserController(UserServiceImpl service) {
        this.service = service;
    }

    /**
     * list all users
     *
     * @return
     */
    @GetMapping(path = "")
    @RolesAllowed({"ROLE_ADMIN"})
    public ResponseEntity<Result> find(@QueryParam("name") Optional<String> name) {
        Result response = service.find(name);
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }

    /**
     * Get user by id
     *
     * @param id
     * @return
     */
    @GetMapping(path = "/{id}")
    @RolesAllowed({"ROLE_ADMIN"})
    public ResponseEntity<Result> findById(@PathVariable(value = "id") String id) {
        Result response = service.findById(id);
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }

    /**
     * Create a new user
     *
     * @return
     */
    @PostMapping(path = "")
    @RolesAllowed({"ROLE_ADMIN"})
    public ResponseEntity<Result> create(@UserValidator @RequestBody User user) {
        Result response = service.create(user);
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }

    /**
     * Update user
     *
     * @param id
     * @return
     */
    @PutMapping(path = "/{id}")
    @RolesAllowed({"ROLE_ADMIN"})
    public ResponseEntity<Result> update(@PathVariable(value = "id") String id,
                                         @QueryParam("group") Optional<String> group,
                                         @QueryParam("role") Optional<String> role) {
        Result response = service.update(id, group, role);
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }

    @PutMapping(path = "/{id}/reset_password")
    @RolesAllowed({"ROLE_ADMIN"})
    public ResponseEntity<Result> resetPassword(@PathVariable(value = "id") String id) {
        Result response = service.resetPassword(id);
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }

    @GetMapping(path = "/{id}/logout")
    public ResponseEntity<Result> logout(@PathVariable(value = "id") String id) {
        Result response = service.logout(id);
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }

}
