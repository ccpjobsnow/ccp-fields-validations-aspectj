package com.ccp.fields.validations.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CcpFieldValidationRules {

	CcpFieldValidationRestrictedValuesRules[] restrictedValues() default {};
	CcpFieldValidationBoundsRules[] bounds() default {};
	CcpFieldValidationSimpleRules[] simple() default {};
	
}
