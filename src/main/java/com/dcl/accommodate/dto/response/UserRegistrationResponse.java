package com.dcl.accommodate.dto.response;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;
import com.dcl.accommodate.enums.UserRoles;

public class UserRegistrationResponse {

    private UUID userId;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private UserRoles roles;
    private String email;
    private String avatar;
    private Instant createdAt;
    private Instant lastModifiedDate;

    public UUID getUserId() {
        return userId;
    }

    public UserRegistrationResponse setUserId(UUID userId) {
        this.userId = userId;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserRegistrationResponse setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegistrationResponse setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public UserRegistrationResponse setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public UserRoles getRoles() {
        return roles;
    }

    public UserRegistrationResponse setRoles(UserRoles roles) {
        this.roles = roles;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegistrationResponse setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public UserRegistrationResponse setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public UserRegistrationResponse setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public UserRegistrationResponse setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
        return this;
    }
}
