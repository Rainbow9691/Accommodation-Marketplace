package com.dcl.accommodate.service;

import com.dcl.accommodate.dto.request.UserRegistrationRequest;
import com.dcl.accommodate.dto.response.UserRegistrationResponse;
import com.dcl.accommodate.exception.UserRegistrationException;
import com.dcl.accommodate.model.User;
import com.dcl.accommodate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dcl.accommodate.enums.UserRoles;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserRegistrationResponse registerUser(UserRegistrationRequest request) {

        User user = setUser(request);
        return Optional.of(userRepository.save(user))
                .map(u-> new UserRegistrationResponse()
                                        .setUserId(u.getUserId())
                                        .setFirstName(u.getFirstName())
                                        .setLastName(u.getLastName())
                                        .setRoles(u.getRoles())
                                        .setEmail(u.getEmail())
                                        .setDateOfBirth(u.getDateOfBirth())
                                        .setAvatar(u.getAvatar())
                                        .setCreatedAt(u.getCreatedAt())
                                        .setLastModifiedDate(u.getLastModifiedDate()))
                .orElseThrow(()->new UserRegistrationException("Problem occurred during user registration"));

    }

    private static User setUser(UserRegistrationRequest request) {
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDateOfBirth(request.getDateOfBirth());
        user.setRoles(request.getRoles());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setPhoneNumber(request.getPhoneNumber());

        return user;
    }
}
