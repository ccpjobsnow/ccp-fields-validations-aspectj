package com.ccp.fields.validations.annotations;

import com.ccp.fields.validations.enums.ArrayValidations;

public @interface ArrayRules {
	ArrayValidations rule ();
	String[] fields();
}
