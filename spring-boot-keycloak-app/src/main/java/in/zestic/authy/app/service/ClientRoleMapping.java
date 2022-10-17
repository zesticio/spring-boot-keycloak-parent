package in.zestic.authy.app.service;

import in.zestic.common.entity.Result;

public interface ClientRoleMapping {

    Result create();

    Result find();

    Result update(String userId);

    Result delete(String userId);
}
