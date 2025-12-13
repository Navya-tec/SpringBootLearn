package practice.practiceSpringbootProject.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordValidation,String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s.length()<10) return false;
        boolean hasUppercase=s.matches(".*[A-Z].*");
        boolean hasLowecase= s.matches(".*[a-z].*");
        boolean hasSpecial = s.matches(".*[^a-zA-Z0-9].*");

        return hasUppercase&&hasLowecase&&hasSpecial;
    }
}
