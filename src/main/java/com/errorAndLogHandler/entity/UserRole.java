package com.errorAndLogHandler.entity;

public enum UserRole {
    
    USER_ROLE("USER_ROLE"),
    ADMIN_ROLE("ADMIN_ROLE");

    private final String code;

    UserRole(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static UserRole fromCode(String code) {
        for (UserRole referenceType : UserRole.values()) {
            if (referenceType.code.equals(code)) {
                return referenceType;
            }
        }
        throw new IllegalArgumentException("Unknown Role: " + code);
    }
}
