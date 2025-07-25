package com.errorAndLogHandler.dto;

import com.errorAndLogHandler.entity.UserRole;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO{
    private String username;
    private String email;
    private String password;
    private UserRole role;
 }
