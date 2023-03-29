package com.interview.schedule.business.service;

import java.util.List;

import com.interview.schedule.business.dtos.UserDto;


public interface UserService {

    public UserDto add(UserDto userDto);

    public List<UserDto> getAll();

    public UserDto getUser(Long id);
}
