package com.ccp.fields.validations.aspects;

import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.ccp.constantes.CcpConstants;
import com.ccp.decorators.CcpJsonRepresentation;
import com.ccp.fields.validations.annotations.CcpFieldValidationBoundsRules;
import com.ccp.fields.validations.annotations.CcpFieldValidationRules;
import com.ccp.fields.validations.annotations.CcpFieldValidationRestrictedValuesRules;
import com.ccp.fields.validations.annotations.CcpFieldValidationSimpleRules;
import com.ccp.fields.validations.enums.BoundsValidations;
import com.ccp.fields.validations.enums.RestrictedValuesValidations;
import com.ccp.fields.validations.enums.SimpleValidations;
import com.ccp.fields.validations.exceptions.CcpJsonInvalid;

@Aspect
public class CcpFieldsValidationsAspect {
	@SuppressWarnings("unchecked")
	@Before("@annotation(com.ccp.fields.validations.annotations.CcpFieldValidationRules)")
    public void validateFields(JoinPoint jp, CcpFieldValidationRules rules) {
		Object[] args = jp.getArgs();
		if(args == null) {
			return;
		}
		if(args.length == 0) {
			return;
		}
		boolean doNotReceiveJson = (args[0] instanceof Map) == false;
		
		if(doNotReceiveJson) {
			return;
		}
		Map<String, Object> map = (Map<String, Object>)args[0];
		CcpJsonRepresentation json = new CcpJsonRepresentation(map);
		
		CcpJsonRepresentation result = CcpConstants.EMPTY_JSON;
		
		result = this.validateBounds(rules, json, result);

		result = this.validateRestricted(rules, json, result);
		
		result = this.validateSimples(rules, json, result);
		
		boolean noErrors = result.isEmpty();
		
		if(noErrors) {
			return;
		}
		
		throw new CcpJsonInvalid(result);
    }

	public CcpJsonRepresentation validateSimples(CcpFieldValidationRules rules, CcpJsonRepresentation json,
			CcpJsonRepresentation result) {
		CcpFieldValidationSimpleRules[] simples = rules.simple();
		
		for (CcpFieldValidationSimpleRules validation : simples) {
			String[] fields = validation.fields();
			SimpleValidations rule = validation.rule();
			boolean validJson = rule.isValidJson(json, fields);
			
			if(validJson) {
				continue;
			}
			result = result.addToList(rule.name(),(Object[]) fields);
		}
		return result;
	}

	public CcpJsonRepresentation validateRestricted(CcpFieldValidationRules rules, CcpJsonRepresentation json,
			CcpJsonRepresentation result) {
		CcpFieldValidationRestrictedValuesRules[] restricteds = rules.restrictedValues();

		for (CcpFieldValidationRestrictedValuesRules validation : restricteds) {
			String[] restrictedValues = validation.allowedValues();
			String[] fields = validation.fields();
			RestrictedValuesValidations rule = validation.rule();
			boolean validJson = rule.isValidJson(json, restrictedValues, fields);
			
			if(validJson) {
				continue;
			}
			result = result.addToList(rule.name(),(Object[]) fields);
		}
		return result;
	}

	public CcpJsonRepresentation validateBounds(CcpFieldValidationRules rules, CcpJsonRepresentation json, CcpJsonRepresentation result) {
		CcpFieldValidationBoundsRules[] bounds = rules.bounds();

		for (CcpFieldValidationBoundsRules validation : bounds) {
			double bound = validation.bound();
			String[] fields = validation.fields();
			BoundsValidations rule = validation.rule();
			boolean validJson = rule.isValidJson(json, bound, fields);
			
			if(validJson) {
				continue;
			}
			result = result.addToList(rule.name(),(Object[]) fields);
		}
		return result;
	}
}
