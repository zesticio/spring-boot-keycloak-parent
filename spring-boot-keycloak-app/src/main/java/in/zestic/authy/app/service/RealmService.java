package in.zestic.authy.app.service;

import in.zestic.authy.keycloak.demo.entity.Realm;
import in.zestic.common.entity.Result;

public interface RealmService {

    public Result create(Realm realm);

    public Result find();
}
