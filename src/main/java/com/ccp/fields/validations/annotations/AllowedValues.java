package com.ccp.fields.validations.annotations;

import com.ccp.fields.validations.enums.AllowedValuesValidations;

public @interface AllowedValues {
	AllowedValuesValidations rule();
	String[] allowedValues();
	String[] fields();
}
