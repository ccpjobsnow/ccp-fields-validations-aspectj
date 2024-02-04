package com.ccp.fields.validations.annotations;

import com.ccp.fields.validations.enums.SimpleValidations;

public @interface CcpFieldValidationSimpleRules {
	SimpleValidations rule ();
	String[] fields();
}
