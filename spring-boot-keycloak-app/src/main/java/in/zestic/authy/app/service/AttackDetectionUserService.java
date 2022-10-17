package in.zestic.authy.app.service;

import in.zestic.common.entity.Result;

public interface AttackDetectionUserService {

    /**
     * Clear any user login failures for the user This can release temporary disabled user
     *
     * @return Result
     */
    Result delete();

    /**
     * Get status of a username in brute force detection
     *
     * @return Result
     */
    Result status();
}
