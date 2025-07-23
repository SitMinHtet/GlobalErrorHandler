package com.errorAndLogHandler.utlis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SecurityUtils {
    
    @Autowired 
    private PasswordEncoder passwordEncoder;

    public String getHash(String plainPassword)
	{
		return passwordEncoder.encode(plainPassword);
	}
}
