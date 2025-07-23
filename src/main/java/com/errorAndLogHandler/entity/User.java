package com.errorAndLogHandler.entity;

import com.errorAndLogHandler.custom.UserRoleConverter;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data 
@NoArgsConstructor
@AllArgsConstructor
public class User{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username",nullable = false)
    private String username;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

    @Convert(converter = UserRoleConverter.class)
    @Column(name = "role")
    private UserRole role;

    public User(String username,String email,String password,UserRole role){
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

}
