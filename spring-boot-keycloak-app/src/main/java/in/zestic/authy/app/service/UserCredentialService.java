package in.zestic.authy.app.service;

import in.zestic.common.entity.Result;

public interface UserCredentialService {

    public Result find();

    public Result delete(String credentialId);
}
