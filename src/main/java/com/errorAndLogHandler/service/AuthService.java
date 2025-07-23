package com.errorAndLogHandler.service;

import com.errorAndLogHandler.dto.LoginResponseDTO;
import com.errorAndLogHandler.dto.UserDTO;

public interface AuthService {
    
    public void register(UserDTO userDto)throws Exception;
    public LoginResponseDTO login(UserDTO userDto); 

    
}
