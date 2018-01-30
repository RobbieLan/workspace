/**
 * 
 */
package com.mock.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author zhailiang
 *
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MyConstraintValidator.class)//ValidateBy: The validation practice will be executed by whom
public @interface MyConstraint {
	//The following three attributes are must in validation annotations
	String message();

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
