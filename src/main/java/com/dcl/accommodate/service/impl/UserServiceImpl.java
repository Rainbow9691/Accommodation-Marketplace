package com.dcl.accommodate.service.impl;

import com.dcl.accommodate.dto.request.UserRegistrationRequest;
import com.dcl.accommodate.enums.UserRole;
import com.dcl.accommodate.exceptions.UserAlreadyExistByEmailException;
import com.dcl.accommodate.model.User;
import com.dcl.accommodate.repository.UserRepository;
import com.dcl.accommodate.service.contracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void registerUser(UserRegistrationRequest request) {
        if(userRepository.existsByEmail(request.email()))
            throw new UserAlreadyExistByEmailException("user account is already exists by given email");

        var user = this.toUser(request);
        user.setRole(UserRole.GUEST); // default role to all users
        userRepository.save(user);
    }

    private User toUser(UserRegistrationRequest request) {
        var user = User.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .dateOfBirth(request.dateOfBirth())
                .password(request.password())
                .phoneNumber(request.phoneNumber())
                .build();

        return user;
    }
}