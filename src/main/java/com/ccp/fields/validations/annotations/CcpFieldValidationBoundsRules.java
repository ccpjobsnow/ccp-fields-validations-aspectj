package com.ccp.fields.validations.annotations;

import com.ccp.fields.validations.enums.BoundsValidations;

public @interface CcpFieldValidationBoundsRules {
	BoundsValidations rule();
	String[] fields();
	double bound();
}
