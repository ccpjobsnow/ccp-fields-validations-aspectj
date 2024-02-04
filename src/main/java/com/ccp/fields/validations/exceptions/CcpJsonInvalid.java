package com.ccp.fields.validations.exceptions;

import com.ccp.decorators.CcpJsonRepresentation;

@SuppressWarnings("serial")
public class CcpJsonInvalid extends RuntimeException {

	public final CcpJsonRepresentation errors;

	public CcpJsonInvalid(CcpJsonRepresentation errors) {
		this.errors = errors;
	}
	
	
	
}
