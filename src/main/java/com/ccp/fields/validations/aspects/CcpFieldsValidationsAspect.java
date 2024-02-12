package com.ccp.fields.validations.aspects;

import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.ccp.constantes.CcpConstants;
import com.ccp.decorators.CcpJsonRepresentation;
import com.ccp.fields.validations.annotations.ArrayNumbers;
import com.ccp.fields.validations.annotations.ArraySize;
import com.ccp.fields.validations.annotations.ArrayTexts;
import com.ccp.fields.validations.annotations.ObjectNumbers;
import com.ccp.fields.validations.annotations.ObjectText;
import com.ccp.fields.validations.annotations.AllowedValues;
import com.ccp.fields.validations.annotations.ValidationRules;
import com.ccp.fields.validations.annotations.ObjectRules;
import com.ccp.fields.validations.enums.BoundValidations;
import com.ccp.fields.validations.enums.AllowedValuesValidations;
import com.ccp.fields.validations.enums.ObjectValidations;
import com.ccp.fields.validations.exceptions.CcpJsonInvalid;

@Aspect
public class CcpFieldsValidationsAspect {
	@SuppressWarnings("unchecked")
	@Before("@annotation(com.ccp.fields.validations.annotations.CcpFieldValidationRules)")
	public void validateFields(JoinPoint jp, ValidationRules rules) {
		Object[] args = jp.getArgs();
		if (args == null) {
			return;
		}
		if (args.length == 0) {
			return;
		}
		boolean doNotReceiveJson = (args[0] instanceof Map) == false;

		if (doNotReceiveJson) {
			return;
		}
		Map<String, Object> map = (Map<String, Object>) args[0];
		CcpJsonRepresentation json = new CcpJsonRepresentation(map);

		Class<?> rulesClass = rules.rulesClass();
		
		rules = rulesClass.isAnnotationPresent(ValidationRules.class) ? rulesClass.getAnnotation(ValidationRules.class) : rules;
		
		CcpJsonRepresentation result = CcpConstants.EMPTY_JSON;

		result = this.validateBounds(rules, json, result);

		result = this.validateRestricted(rules, json, result);

		result = this.validateSimples(rules, json, result);

		boolean noErrors = result.isEmpty();

		if (noErrors) {
			return;
		}

		throw new CcpJsonInvalid(result);
	}

	public CcpJsonRepresentation validateSimples(ValidationRules rules, CcpJsonRepresentation json,
			CcpJsonRepresentation result) {
		ObjectRules[] simples = rules.simpleObjectRules();

		for (ObjectRules validation : simples) {
			String[] fields = validation.fields();
			ObjectValidations rule = validation.rule();
			boolean validJson = rule.isValidJson(json, fields);

			if (validJson) {
				continue;
			}
			result = result.addToList(rule.name(), (Object[]) fields);
		}
		return result;
	}

	public CcpJsonRepresentation validateRestricted(ValidationRules rules, CcpJsonRepresentation json,
			CcpJsonRepresentation result) {
		AllowedValues[] restricteds = rules.allowedValues();

		for (AllowedValues validation : restricteds) {
			String[] restrictedValues = validation.allowedValues();
			String[] fields = validation.fields();
			AllowedValuesValidations rule = validation.rule();
			boolean validJson = rule.isValidJson(json, restrictedValues, fields);

			if (validJson) {
				continue;
			}
			result = result.addToList(rule.name(), (Object[]) fields);
		}
		return result;
	}

	public CcpJsonRepresentation validateBounds(ValidationRules rules, CcpJsonRepresentation json,
			CcpJsonRepresentation result) {

		{
			ArrayNumbers[] x1 = rules.arrayNumbersValidations();

			for (ArrayNumbers validation : x1) {
				double bound = validation.bound();
				String[] fields = validation.fields();
				BoundValidations rule = validation.rule();
				boolean validJson = rule.isValidJson(json, bound, fields);

				if (validJson) {
					continue;
				}
				result = result.addToList(rule.name(), (Object[]) fields);
			}

		}

		{
			ArraySize[] x1 = rules.arraySizeValidations();

			for (ArraySize validation : x1) {
				double bound = validation.bound();
				String[] fields = validation.fields();
				BoundValidations rule = validation.rule();
				boolean validJson = rule.isValidJson(json, bound, fields);

				if (validJson) {
					continue;
				}
				result = result.addToList(rule.name(), (Object[]) fields);
			}

		}
		{
			ArrayTexts[] x1 = rules.arrayTextsValidations();

			for (ArrayTexts validation : x1) {
				double bound = validation.bound();
				String[] fields = validation.fields();
				BoundValidations rule = validation.rule();
				boolean validJson = rule.isValidJson(json, bound, fields);

				if (validJson) {
					continue;
				}
				result = result.addToList(rule.name(), (Object[]) fields);
			}

		}
		{
			ObjectNumbers[] x1 = rules.objectNumbersValidations();

			for (ObjectNumbers validation : x1) {
				double bound = validation.bound();
				String[] fields = validation.fields();
				BoundValidations rule = validation.rule();
				boolean validJson = rule.isValidJson(json, bound, fields);

				if (validJson) {
					continue;
				}
				result = result.addToList(rule.name(), (Object[]) fields);
			}

		}
		{
			ObjectText[] x1 = rules.objectTextsValidations();

			for (ObjectText validation : x1) {
				double bound = validation.bound();
				String[] fields = validation.fields();
				BoundValidations rule = validation.rule();
				boolean validJson = rule.isValidJson(json, bound, fields);

				if (validJson) {
					continue;
				}
				result = result.addToList(rule.name(), (Object[]) fields);
			}

		}
		return result;
	}
}
