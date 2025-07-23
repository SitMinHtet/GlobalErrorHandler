package com.errorAndLogHandler.custom;

import com.errorAndLogHandler.entity.UserRole;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class UserRoleConverter implements AttributeConverter<UserRole, String> {

    @Override
    public String convertToDatabaseColumn(UserRole attribute) {
        return attribute != null ? attribute.getCode() : null;
    }

    @Override
    public UserRole convertToEntityAttribute(String code) {
        return code != null ? UserRole.fromCode(code) : null;
    }
    
}
