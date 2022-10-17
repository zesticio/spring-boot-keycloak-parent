package in.zestic.authy.app.service;

import in.zestic.common.entity.Result;

public interface ClientSecretService {

    Result create();

    Result findById();
}
