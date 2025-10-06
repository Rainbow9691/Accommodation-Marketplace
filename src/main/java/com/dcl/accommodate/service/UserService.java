package com.dcl.accommodate.service;

import com.dcl.accommodate.dto.request.UserRegistrationRequest;
import com.dcl.accommodate.dto.response.UserRegistrationResponse;

public interface UserService {
    UserRegistrationResponse registerUser(UserRegistrationRequest request);
}
