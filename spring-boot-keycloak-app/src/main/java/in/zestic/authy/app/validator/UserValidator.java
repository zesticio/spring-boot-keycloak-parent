package in.zestic.authy.app.validator;

import in.zestic.authy.app.validator.impl.UserValidationImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserValidationImpl.class)
public @interface UserValidator {

    String message() default "Invalid user object";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
