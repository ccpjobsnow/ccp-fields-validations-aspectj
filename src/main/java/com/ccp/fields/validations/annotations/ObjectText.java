package com.ccp.fields.validations.annotations;

import com.ccp.fields.validations.enums.ObjectTextSizeValidations;

public @interface ObjectText {

	ObjectTextSizeValidations rule();
	String[] fields();
	double bound();

}
