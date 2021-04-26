package com.reports.audit.enums;

/**
 * 
 * @author rashmi
 * @version 1.0
 * 
 * Enum for specifying Response Status
 *
 */
public enum StatusEnum {
	SUCCESS("Success"), FAIL("Fail");

	private final String value;

	StatusEnum(String value) {
		this.value = value;
	}

	public String value() {
		return this.value;
	}

	@Override
	public String toString() {
		return this.value;
	}
}
