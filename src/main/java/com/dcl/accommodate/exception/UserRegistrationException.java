package com.dcl.accommodate.exception;

public class UserRegistrationException extends RuntimeException{

    private String error;
    public UserRegistrationException(String error){
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
