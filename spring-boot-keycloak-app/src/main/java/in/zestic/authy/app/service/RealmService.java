package in.zestic.authy.app.service;

import in.zestic.authy.keycloak.api.entity.Client;
import in.zestic.authy.keycloak.api.entity.Realm;
import in.zestic.common.entity.Result;

public interface RealmService {

    public Result create(Realm realm);

    public Result find();

    public Result update(String id);

    public Result delete(String id);
}
