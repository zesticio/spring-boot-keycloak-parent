package in.zestic.authy.app.validator.impl;

import in.zestic.authy.app.validator.ClientValidation;
import in.zestic.authy.keycloak.demo.entity.Client;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ClientValidationImpl implements ConstraintValidator<ClientValidation, Client> {

    @Override
    public boolean isValid(Client client, ConstraintValidatorContext constraintValidatorContext) {
        return true;
    }
}
