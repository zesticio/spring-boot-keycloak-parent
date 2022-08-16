package com.zestic.authy.app.validator.impl;

import com.zestic.authy.app.validator.UserValidator;
import com.zestic.authy.keycloak.entity.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserValidationImpl implements ConstraintValidator<UserValidator, User> {

    @Override
    public boolean isValid(User user, ConstraintValidatorContext constraintValidatorContext) {
        return true;
    }
}
