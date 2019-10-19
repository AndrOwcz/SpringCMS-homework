package pl.coderslab.app.article;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TitleSizeValidator implements ConstraintValidator<TitleSize, String> {

    @Override
    public void initialize (TitleSize constraintAnnotation) {
    }

    @Override
    public boolean isValid(String title, ConstraintValidatorContext context) {
        return title.length() < 200;
    }
}
