package com.interview.schedule.presentation.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.schedule.business.dtos.ResponseDto;
import com.interview.schedule.business.dtos.UserDto;
import com.interview.schedule.business.service.UserService;

import lombok.RequiredArgsConstructor;

// @AllArgsConstructor
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    
    final private UserService userService;

    @PostMapping
    public ResponseDto addUser(@RequestBody UserDto userDto)
    {
        return new ResponseDto(
            "User Added Successfully",
            200,
            userService.add(userDto)
        );
    }

    @GetMapping
    public ResponseDto getAllUsers()
    {
        return new ResponseDto("All Users", 200, userService.getAll());
    }
    
    @GetMapping("/{id}")
    public ResponseDto getUser(@PathVariable Long id)
    {
        return new ResponseDto("this the user with id "+id+"", 200,userService.getUser(id));
    }
}
