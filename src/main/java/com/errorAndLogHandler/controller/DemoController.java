package com.errorAndLogHandler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.errorAndLogHandler.service.AuthService;

@RestController
@RequestMapping("/api")
public class DemoController {

    @Autowired
    private AuthService userService;
    
    @GetMapping("/hello")
    @PreAuthorize("hasRole('ADMIN_ROLE','USER_ROLE')")
    public ResponseEntity<?> helloworld(Authentication authentication){
        String currentUsername = authentication.getName();
        System.out.println(currentUsername);
        return ResponseEntity.ok("hello world");
    }
}
