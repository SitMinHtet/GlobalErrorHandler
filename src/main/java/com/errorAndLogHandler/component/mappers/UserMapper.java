package com.errorAndLogHandler.component.mappers;

import org.springframework.stereotype.Component;

import com.errorAndLogHandler.dto.UserDTO;
import com.errorAndLogHandler.entity.User;

@Component
public class UserMapper {

    public UserDTO toDto(User user) {
        if (user == null) return null;
        return new UserDTO(user.getId(), user.getName(), user.getEmail());
    }

    public User toEntity(UserDTO dto) {
        if (dto == null) return null;
        return new User(dto.id(), dto.name(), dto.email());
    }
}
