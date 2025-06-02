package com.errorAndLogHandler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.errorAndLogHandler.component.mappers.UserMapper;
import com.errorAndLogHandler.dto.UserDTO;
import com.errorAndLogHandler.entity.User;
import com.errorAndLogHandler.exception.commonException.NotFoundException;
import com.errorAndLogHandler.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .toList();
    }

    public UserDTO getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(userMapper::toDto)
                .orElseThrow(() -> new NotFoundException("User not found with email: " + email));
    }

    public UserDTO save(UserDTO dto) {
        User saved = userRepository.save(userMapper.toEntity(dto));
        return userMapper.toDto(saved);
    }
}
