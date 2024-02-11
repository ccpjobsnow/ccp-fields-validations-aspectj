package com.ccp.fields.validations.annotations;

import com.ccp.fields.validations.enums.ArrayNumbersValidations;

public @interface ArrayNumbers {

	ArrayNumbersValidations rule();
	String[] fields();
	double bound();
}
