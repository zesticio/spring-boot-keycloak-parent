package in.zestic.authy.app.service;

import in.zestic.common.entity.Result;

public interface ClientScopeService {

    Result create();

    Result find();

    Result findById(String clientScopeId);

    Result update(String clientScopeId);

    Result delete(String clientScopeId);
}
