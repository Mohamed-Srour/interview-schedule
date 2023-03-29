package com.interview.schedule.business.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.interview.schedule.business.dtos.UserDto;
import com.interview.schedule.persistence.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto map(User user);

    User map(UserDto userDto);

    // List<User> map(List<UserDto> userDto);

    List<UserDto> map(List<User> user);
}
