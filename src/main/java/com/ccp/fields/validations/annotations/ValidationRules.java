package com.ccp.fields.validations.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ValidationRules {

	ObjectRules[] simpleObjectRules() default {};
	ArrayRules[] simpleArrayRules() default {};
	AllowedValues[] allowedValues() default {};

	ObjectNumbers[] objectNumbersValidations() default {};
	ArrayNumbers[] arrayNumbersValidations() default {};
	ObjectText[] objectTextsValidations() default {};
	ArrayTexts[] arrayTextsValidations() default {};
	ArraySize[] arraySizeValidations() default {};

}
