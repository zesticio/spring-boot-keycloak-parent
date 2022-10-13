package in.zestic.authy.app.service;

import in.zestic.common.entity.Result;

public interface AttackDetectionService {

    /**
     * Clear any user login failures for all users This can release temporary disabled users
     *
     * @return
     */
    Result delete();

    /**
     * Clear any user login failures for the user This can release temporary disabled user
     *
     * @param userId
     * @return
     */
    Result delete(String userId);

    /**
     * Get status of a username in brute force detection
     *
     * @param userId
     * @return
     */
    Result status(String userId);
}
