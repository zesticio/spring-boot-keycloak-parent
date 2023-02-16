package in.zestic.authy.app.validator.impl;

import in.zestic.authy.app.validator.UserValidation;
import in.zestic.authy.keycloak.demo.entity.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserValidationImpl implements ConstraintValidator<UserValidation, User> {

    @Override
    public boolean isValid(User user, ConstraintValidatorContext constraintValidatorContext) {
        return true;
    }
}
