package com.vinisolon.studentsregister.students.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Gender {
    MALE(1),
    FEMALE(2),
    UNINFORMED(3);

    private final int code;

    @JsonCreator
    public static Gender valueOfCode(int code) {
        for (Gender value : Gender.values()) {
            if (value.getCode() == code)
                return value;
        }
        throw new IllegalArgumentException("Invalid gender code.");
    }

    @JsonValue
    public int getCode() {
        return code;
    }
}
