package com.ccp.fields.validations.annotations;

import com.ccp.fields.validations.enums.ArraySizeValidations;

public @interface ArraySize {
	ArraySizeValidations rule();
	String[] fields();
	double bound();

}
