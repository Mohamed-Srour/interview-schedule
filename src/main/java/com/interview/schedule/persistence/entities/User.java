package com.interview.schedule.persistence.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.interview.schedule.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String emailId;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String mobile;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String profileUrl;

    @Column(name = "forgetToken",unique = true,nullable = true)
    private String forgetToken;

    private Integer otb;
}
