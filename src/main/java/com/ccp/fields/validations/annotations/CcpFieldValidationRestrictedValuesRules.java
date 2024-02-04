package com.ccp.fields.validations.annotations;

import com.ccp.fields.validations.enums.RestrictedValuesValidations;

public @interface CcpFieldValidationRestrictedValuesRules {
	RestrictedValuesValidations rule();
	String[] allowedValues();
	String[] fields();
}
