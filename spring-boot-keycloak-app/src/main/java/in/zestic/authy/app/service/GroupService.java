package in.zestic.authy.app.service;

import in.zestic.common.entity.Result;

public interface GroupService {

    public Result create();

    public Result find();

    public Result count();

    public Result findById(String userId);

    public Result update(String userId);

    public Result delete(String userId);
}
