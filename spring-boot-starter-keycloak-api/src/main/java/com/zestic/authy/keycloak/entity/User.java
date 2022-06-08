package com.zestic.authy.keycloak.entity;

import com.zestic.common.entity.Entity;
import lombok.Data;

import java.util.List;

@Data
public class User extends Entity {

    private String userId;
    private String username;
    private String email;
    private String msisdn;
    private String passport;
}
