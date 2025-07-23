package com.errorAndLogHandler.component.mappers;

import org.springframework.stereotype.Component;

import com.errorAndLogHandler.dto.UserDTO;
import com.errorAndLogHandler.entity.User;

@Component
public class UserMapper {

    public static UserDTO toDto(User user) {
        if (user == null) return null;
        return new UserDTO(user.getUsername(), user.getEmail(),user.getPassword() ,user.getRole());
    }

    public static User toEntity(UserDTO dto) {
        if (dto == null) return null;
        return new User(dto.getUsername(), dto.getEmail(),dto.getPassword(), dto.getRole());
    }
}
