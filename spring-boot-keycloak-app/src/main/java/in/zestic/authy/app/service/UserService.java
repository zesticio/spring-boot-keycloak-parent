package in.zestic.authy.app.service;

import in.zestic.authy.keycloak.demo.entity.User;
import in.zestic.common.entity.Result;

import java.util.Optional;

public interface UserService {

    public Result find(Optional<String> name);

    public Result findById(String id);

    public Result create(User user);

    public Result update(String id, Optional<String> group, Optional<String> role);

    public Result resetPassword(String id);

    public Result logout(String id);

    public Result assignRole(String id);
}
