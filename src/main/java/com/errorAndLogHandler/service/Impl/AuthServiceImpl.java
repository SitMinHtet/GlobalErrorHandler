package com.errorAndLogHandler.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.errorAndLogHandler.component.mappers.UserMapper;
import com.errorAndLogHandler.dto.LoginResponseDTO;
import com.errorAndLogHandler.dto.UserDTO;
import com.errorAndLogHandler.entity.User;
import com.errorAndLogHandler.entity.UserRole;
import com.errorAndLogHandler.exception.commonException.InvalidCredentialsException;
import com.errorAndLogHandler.exception.commonException.UserAlreadyExistException;
import com.errorAndLogHandler.repository.UserRepository;
import com.errorAndLogHandler.security.JwtService;
import com.errorAndLogHandler.service.AuthService;
import com.errorAndLogHandler.utlis.SecurityUtils;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityUtils securityUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Override
    public void register(UserDTO userDto) throws Exception {

        User existingUser = userRepository.findByUsername(userDto.getUsername());

        if(existingUser!=null){
			throw new UserAlreadyExistException("User already existed");
		}else{
            userDto.setPassword(securityUtils.getHash(userDto.getPassword()));
            userDto.setRole(UserRole.USER_ROLE);
            User user = UserMapper.toEntity(userDto);
			userRepository.save(user);
		}
    }

    @Override
	public LoginResponseDTO login(UserDTO userDto) {
		try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDto.getUsername(), userDto.getPassword()));
        } catch (BadCredentialsException ex) {
            throw new InvalidCredentialsException("Invalid username or password");
        }
        User user = userRepository.findByUsername(userDto.getUsername());
        if (user == null) {
            throw new InvalidCredentialsException("Invalid username or password");
        }
        String token =  jwtService.generateToken(user);
        LoginResponseDTO loginResponseDTO = new LoginResponseDTO(token,user.getUsername(),user.getEmail());
        return loginResponseDTO;
	}
    
}
