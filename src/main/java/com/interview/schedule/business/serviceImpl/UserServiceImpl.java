package com.interview.schedule.business.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.schedule.business.dtos.UserDto;
import com.interview.schedule.business.mappers.UserMapper;
import com.interview.schedule.business.service.UserService;
import com.interview.schedule.exceptions.ResourceNotFoundException;
import com.interview.schedule.persistence.entities.User;
import com.interview.schedule.persistence.repositories.UserRepo;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDto add(UserDto userDto) {

       User user= userRepo.save(userMapper.map(userDto));   
       return userMapper.map(user);
    }

    @Override
    public List<UserDto> getAll() {
        if(userRepo.findAll().isEmpty())
        {
            throw new ResourceNotFoundException(null);
        }
        return userMapper.map(userRepo.findAll());

    }

    @Override
    public UserDto getUser(Long id) {
        Optional<User>user= userRepo.findById(id);
        user.orElseThrow(()->new ResourceNotFoundException(id));
        return userMapper.map(user.get());
    }
    
}
