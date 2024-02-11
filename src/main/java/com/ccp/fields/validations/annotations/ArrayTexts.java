package com.ccp.fields.validations.annotations;

import com.ccp.fields.validations.enums.ArrayTextsSizeValidations;

public @interface ArrayTexts {
	ArrayTextsSizeValidations rule();
	String[] fields();
	double bound();

}
