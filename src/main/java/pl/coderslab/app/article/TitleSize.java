package pl.coderslab.app.article;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = TitleSizeValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TitleSize {

    String message() default "Title length must be less then 200 characters";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
