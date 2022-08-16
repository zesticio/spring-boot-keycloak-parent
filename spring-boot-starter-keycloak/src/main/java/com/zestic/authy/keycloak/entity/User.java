package com.zestic.authy.keycloak.entity;

import com.zestic.common.entity.Entity;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class User extends Entity {

    private String userId;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String msisdn;
    private String passport;

    private Map<String, List<String>> attributes;
}
