package com.IES.Enum;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Gender {
	
	MALE,
    FEMALE,
    OTHER;
    
	@JsonCreator
    public static Gender fromValue(String value) {
        if (value == null) {
            return null;
        }
        try {
            return Gender.valueOf(value.trim().toUpperCase());
        } catch (IllegalArgumentException ex) {
            // Optionally, throw a more descriptive exception here
            throw new IllegalArgumentException(
                "Invalid gender value: " + value + ". Allowed: Male, Female, Other"
            );
        }
    }

    @JsonValue
    public String toValue() {
        // Return "Male" instead of "MALE"
        String lower = name().toLowerCase();
        return Character.toUpperCase(lower.charAt(0)) + lower.substring(1);
    }

}
