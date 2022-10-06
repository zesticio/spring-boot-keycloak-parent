package in.zestic.authy.app.validator.impl;

import in.zestic.authy.app.validator.UserValidator;
import in.zestic.authy.keycloak.api.entity.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserValidationImpl implements ConstraintValidator<UserValidator, User> {

    @Override
    public boolean isValid(User user, ConstraintValidatorContext constraintValidatorContext) {
        return true;
    }
}
