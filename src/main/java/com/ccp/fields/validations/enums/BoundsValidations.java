package com.ccp.fields.validations.enums;

import com.ccp.decorators.CcpJsonRepresentation;

public enum BoundsValidations {
	FieldArraysWithSizeEqualsTo 
	{
		public boolean isValidJson(CcpJsonRepresentation json, double bound, String... fields) {
			return json.itIsTrueThatTheFollowingFields(fields).ifTheyAreAllArrayValuesThenEachOne().hasTheSizeThatIs().equalsTo(bound);
		}
	},
	FieldArraysWithSizeEqualsOrGreaterThan
	{
		public boolean isValidJson(CcpJsonRepresentation json, double bound, String... fields) {
			return json.itIsTrueThatTheFollowingFields(fields).ifTheyAreAllArrayValuesThenEachOne().hasTheSizeThatIs().equalsOrGreaterThan(bound);
		}
	},
	FieldArraysWithSizeEqualsOrLessThan
	{
		public boolean isValidJson(CcpJsonRepresentation json, double bound, String... fields) {
			return json.itIsTrueThatTheFollowingFields(fields).ifTheyAreAllArrayValuesThenEachOne().hasTheSizeThatIs().equalsOrLessThan(bound);
		}
	},
	FieldArraysWithSizeGreaterThan
	{
		public boolean isValidJson(CcpJsonRepresentation json, double bound, String... fields) {
			return json.itIsTrueThatTheFollowingFields(fields).ifTheyAreAllArrayValuesThenEachOne().hasTheSizeThatIs().greaterThan(bound);
		}
	},
	FieldArraysWithSizeLessThan
	{
		public boolean isValidJson(CcpJsonRepresentation json, double bound, String... fields) {
			return json.itIsTrueThatTheFollowingFields(fields).ifTheyAreAllArrayValuesThenEachOne().hasTheSizeThatIs().lessThan(bound);
		}
	},
	FieldArrayTextsWithSizeEqualsOrLessThan
	{
		public boolean isValidJson(CcpJsonRepresentation json, double bound, String... fields) {
			return json.itIsTrueThatTheFollowingFields(fields).ifTheyAreAllArrayValuesThenEachOne().isTextAnd().hasTheSizeThatIs().equalsTo(bound);
		}
	},
	FieldArrayTextsWithSizeEqualsOrGreaterThan
	{
		public boolean isValidJson(CcpJsonRepresentation json, double bound, String... fields) {
			return json.itIsTrueThatTheFollowingFields(fields).ifTheyAreAllArrayValuesThenEachOne().isTextAnd().hasTheSizeThatIs().equalsOrGreaterThan(bound);
		}
	},
	FieldArrayTextsWithSizeEqualsOrLessThan2
	{
		public boolean isValidJson(CcpJsonRepresentation json, double bound, String... fields) {
			return json.itIsTrueThatTheFollowingFields(fields).ifTheyAreAllArrayValuesThenEachOne().isTextAnd().hasTheSizeThatIs().equalsOrLessThan(bound);
		}
	},
	FieldArrayTextsWithSizeGreaterThan
	{
		public boolean isValidJson(CcpJsonRepresentation json, double bound, String... fields) {
			return json.itIsTrueThatTheFollowingFields(fields).ifTheyAreAllArrayValuesThenEachOne().isTextAnd().hasTheSizeThatIs().greaterThan(bound);
		}
	},
	FieldArrayTexstWithSizeLessThan
	{
		public boolean isValidJson(CcpJsonRepresentation json, double bound, String... fields) {
			return json.itIsTrueThatTheFollowingFields(fields).ifTheyAreAllArrayValuesThenEachOne().isTextAnd().hasTheSizeThatIs().lessThan(bound);
		}
	},
	FieldArrayNumbersWithValueEqualsTo
	{
		public boolean isValidJson(CcpJsonRepresentation json, double bound, String... fields) {
			return json.itIsTrueThatTheFollowingFields(fields).ifTheyAreAllArrayValuesThenEachOne().isNumberAndItIs().equalsTo(bound);
		}
	},
	FieldArrayNumbersWithValueEqualsOrGreaterThan
	{
		public boolean isValidJson(CcpJsonRepresentation json, double bound, String... fields) {
			return json.itIsTrueThatTheFollowingFields(fields).ifTheyAreAllArrayValuesThenEachOne().isNumberAndItIs().equalsOrGreaterThan(bound);
		}
	},
	FieldArrayNumbersWithValueEqualsOrLessThan
	{
		public boolean isValidJson(CcpJsonRepresentation json, double bound, String... fields) {
			return json.itIsTrueThatTheFollowingFields(fields).ifTheyAreAllArrayValuesThenEachOne().isNumberAndItIs().equalsOrLessThan(bound);
		}
	},
	FieldArrayNumbersWithValueGreaterThan
	{
		public boolean isValidJson(CcpJsonRepresentation json, double bound, String... fields) {
			return json.itIsTrueThatTheFollowingFields(fields).ifTheyAreAllArrayValuesThenEachOne().isNumberAndItIs().greaterThan(bound);
		}
	},
	FieldArrayNumbersWithValueLessThan
	{
		public boolean isValidJson(CcpJsonRepresentation json, double bound, String... fields) {
			return json.itIsTrueThatTheFollowingFields(fields).ifTheyAreAllArrayValuesThenEachOne().isNumberAndItIs().lessThan(bound);
		}
	},
	FieldObjectTextsWithSizeEqualsTo
	{
		public boolean isValidJson(CcpJsonRepresentation json, double bound, String... fields) {
			return json.itIsTrueThatTheFollowingFields(fields).ifTheyAreAll().textsThenEachOneHasTheSizeThatIs().equalsTo(bound);
		}
	},
	FieldObjectTextsWithSizeEqualsOrGreaterThan
	{
		public boolean isValidJson(CcpJsonRepresentation json, double bound, String... fields) {
			return json.itIsTrueThatTheFollowingFields(fields).ifTheyAreAll().textsThenEachOneHasTheSizeThatIs().equalsOrGreaterThan(bound);
		}
	},
	FieldObjectTextsWithSizeEqualsOrLessThan
	{
		public boolean isValidJson(CcpJsonRepresentation json, double bound, String... fields) {
			return json.itIsTrueThatTheFollowingFields(fields).ifTheyAreAll().textsThenEachOneHasTheSizeThatIs().equalsOrLessThan(bound);
		}
	},
	FieldObjectTextsWithSizeGreaterThan
	{
		public boolean isValidJson(CcpJsonRepresentation json, double bound, String... fields) {
			return json.itIsTrueThatTheFollowingFields(fields).ifTheyAreAll().textsThenEachOneHasTheSizeThatIs().greaterThan(bound);
		}
	},
	FieldObjctTextsWithSizeLessThan
	{
		public boolean isValidJson(CcpJsonRepresentation json, double bound, String... fields) {
			return json.itIsTrueThatTheFollowingFields(fields).ifTheyAreAll().textsThenEachOneHasTheSizeThatIs().lessThan(bound);
		}
	},
	FieldObjectNumbersWithValueEqualsTo
	{
		public boolean isValidJson(CcpJsonRepresentation json, double bound, String... fields) {
			return json.itIsTrueThatTheFollowingFields(fields).ifTheyAreAll().numbersThenEachOneIs().equalsTo(bound);
		}
	},
	FieldObjectNumbersWithValueEqualsOrGreaterThan
	{
		public boolean isValidJson(CcpJsonRepresentation json, double bound, String... fields) {
			return json.itIsTrueThatTheFollowingFields(fields).ifTheyAreAll().numbersThenEachOneIs().equalsOrGreaterThan(bound);
		}
	},
	FieldObjectNumbersWithValueEqualsOrLessThan
	{
		public boolean isValidJson(CcpJsonRepresentation json, double bound, String... fields) {
			return json.itIsTrueThatTheFollowingFields(fields).ifTheyAreAll().numbersThenEachOneIs().equalsOrLessThan(bound);
		}
	},
	FieldObjectNumbersWithValueGreaterThan
	{
		public boolean isValidJson(CcpJsonRepresentation json, double bound, String... fields) {
			return json.itIsTrueThatTheFollowingFields(fields).ifTheyAreAll().numbersThenEachOneIs().greaterThan(bound);
		}
	},
	FieldObjctNumbersWithValueLessThan
	{
		public boolean isValidJson(CcpJsonRepresentation json, double bound, String... fields) {
			return json.itIsTrueThatTheFollowingFields(fields).ifTheyAreAll().numbersThenEachOneIs().lessThan(bound);
		}
	},
	;
	public abstract boolean isValidJson(CcpJsonRepresentation json, double bound, String... fields);

}
