package com.ccp.fields.validations.enums;

import com.ccp.decorators.CcpJsonRepresentation;

public enum SimpleValidations {
	RequiredFields {
		
		public boolean isValidJson(CcpJsonRepresentation json, String... fields) {
			return json.containsAllKeys(fields);
		}
	},
	BooleanFields {
		
		public boolean isValidJson(CcpJsonRepresentation json, String... fields) {
			return json.itIsTrueThatTheFollowingFields(fields).areAllOfTheType().bool();
		}
	},
	DoubleFields {
		
		public boolean isValidJson(CcpJsonRepresentation json, String... fields) {
			return json.itIsTrueThatTheFollowingFields(fields).areAllOfTheType().doubleNumber();
		}
	},
	JsonFields {
		
		public boolean isValidJson(CcpJsonRepresentation json, String... fields) {
			return json.itIsTrueThatTheFollowingFields(fields).areAllOfTheType().json();
		}
	},
	ListFields {
		
		public boolean isValidJson(CcpJsonRepresentation json, String... fields) {
			return json.itIsTrueThatTheFollowingFields(fields).areAllOfTheType().list();
		}
	},
	IntegerFields {
		
		public boolean isValidJson(CcpJsonRepresentation json, String... fields) {
			return json.itIsTrueThatTheFollowingFields(fields).areAllOfTheType().longNumber();
		}
	},
	NonRepeatedLists {
		
		public boolean isValidJson(CcpJsonRepresentation json, String... fields) {
			return json.itIsTrueThatTheFollowingFields(fields).ifTheyAreAllArrayValuesThenEachOne().hasNonDuplicatedItems();
		}
	},
	;
	public abstract boolean isValidJson(CcpJsonRepresentation json, String... fields);
}
