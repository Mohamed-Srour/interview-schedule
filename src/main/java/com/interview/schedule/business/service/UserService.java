package com.interview.schedule.business.service;

import java.util.List;

import com.interview.schedule.business.dtos.UserDto;
import com.interview.schedule.persistence.entities.User;


public interface UserService {

    public UserDto add(UserDto userDto);

    public List<UserDto> getAll();

    public UserDto getUser(Long id);

    public User findUserByEmailId(String emailId,Long id) throws Exception;    
}
