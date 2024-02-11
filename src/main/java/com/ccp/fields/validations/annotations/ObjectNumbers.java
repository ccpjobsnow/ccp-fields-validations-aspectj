package com.ccp.fields.validations.annotations;

import com.ccp.fields.validations.enums.ObjectNumberValidations;

public @interface ObjectNumbers {
	ObjectNumberValidations rule();
	String[] fields();
	double bound();

}
