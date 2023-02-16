package in.zestic.authy.app.service;

import in.zestic.authy.keycloak.demo.entity.Client;
import in.zestic.common.entity.Result;

public interface ClientService {

    public Result create(Client client);

    public Result find();

    public Result findById(String userId);

    public Result update(String userId);

    public Result delete(String userId);
}
