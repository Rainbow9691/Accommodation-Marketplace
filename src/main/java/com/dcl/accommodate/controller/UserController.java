package com.dcl.accommodate.controller;

import com.dcl.accommodate.dto.request.UserRegistrationRequest;
import com.dcl.accommodate.dto.response.UserRegistrationResponse;
import com.dcl.accommodate.model.User;
import com.dcl.accommodate.service.UserService;
import com.dcl.accommodate.shared.ResponseStructure;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserRegistrationResponse>  registerUser(@RequestBody @Valid UserRegistrationRequest request){
        UserRegistrationResponse response = userService.registerUser(request);
        return ResponseEntity.ok(response);
    }
}
