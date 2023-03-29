package com.interview.schedule.business.dtos;

import com.interview.schedule.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
   
    private Long id;
    private String name;
    private String address;
    private String emailId;
    private String password;
    private String mobile;
    private Role role;
    private String profileUrl;
    private String forgetToken;
    private Integer otb;
}
