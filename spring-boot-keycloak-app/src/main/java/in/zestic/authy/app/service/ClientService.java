package in.zestic.authy.app.service;

import in.zestic.authy.keycloak.api.entity.Client;
import in.zestic.authy.keycloak.api.entity.User;
import in.zestic.common.entity.Result;

import java.util.Optional;

public interface ClientService {

    public Result create(Client client);

    public Result find();

    public Result findById(String userId);

    public Result update(String userId);

    public Result delete(String userId);
}
