package com.dcl.accommodate.model;

import com.dcl.accommodate.ENUMS.UserRoles;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.sound.sampled.AudioFileFormat;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Entity
@Setter
@Getter
@Table(name = "User")
@EntityListeners(AudioFileFormat.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id", nullable = false)
    private UUID userId;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;
    @Enumerated(EnumType.STRING)
    private UserRoles roles;
    @Column(name = "email", nullable = false,unique = true)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @Column(name = "avatar")
    private String avatar;
    @Column(name = "created_date", nullable = false,updatable = true)
    private Instant createdAt;
    @Column(name = "last_modified_date")
    private Instant lastModifiedDate;

}
