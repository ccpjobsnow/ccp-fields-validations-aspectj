package com.ccp.fields.validations.annotations;

import com.ccp.fields.validations.enums.ObjectValidations;

public @interface ObjectRules {
	ObjectValidations rule ();
	String[] fields();
}
