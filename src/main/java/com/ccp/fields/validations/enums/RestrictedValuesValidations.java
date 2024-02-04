package com.ccp.fields.validations.enums;

import java.util.Arrays;
import java.util.List;

import com.ccp.decorators.CcpJsonRepresentation;

public enum RestrictedValuesValidations {
	FieldArrayTextsThatAreContainedAtTheList {

		public boolean isValidJson(CcpJsonRepresentation json, List<Object> restrictedValues, String... fields) {
			return json.itIsTrueThatTheFollowingFields(fields).ifTheyAreAllArrayValuesThenEachOne()
					.isTextAndItIsContainedAtTheList(restrictedValues);
		}
	},
	FieldArrayNumbersThatAreContainedAtTheList {
		public boolean isValidJson(CcpJsonRepresentation json, List<Object> restrictedValues, String... fields) {
			return json.itIsTrueThatTheFollowingFields(fields).ifTheyAreAllArrayValuesThenEachOne()
					.isNumberAndItIsContainedAtTheList(restrictedValues);
		}
	},
	FieldObjectTextsThatAreContainedAtTheList {
		public boolean isValidJson(CcpJsonRepresentation json, List<Object> restrictedValues, String... fields) {
			return json.itIsTrueThatTheFollowingFields(fields).ifTheyAreAll().textsThenEachOneIsContainedAtTheList(restrictedValues);
		}
	},
	FieldObjectNumbersThatAreContainedAtTheList {
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public boolean isValidJson(CcpJsonRepresentation json, List<Object> restrictedValues, String... fields) {
			return json.itIsTrueThatTheFollowingFields(fields).ifTheyAreAll().numbersThenEachOneIsContainedAtTheList((List)restrictedValues);
		}
	},
	
	;
	public abstract boolean isValidJson(CcpJsonRepresentation json, List<Object> restrictedValues, String... fields);
	public boolean isValidJson(CcpJsonRepresentation json, Object[] restrictedValues, String... fields) {
		List<Object> asList = Arrays.asList(restrictedValues);
		boolean validJson = this.isValidJson(json, asList, fields);
		return validJson;
	}

}
