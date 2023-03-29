package com.interview.schedule.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.interview.schedule.persistence.entities.User;

public interface UserRepo extends JpaRepository<User,Long>{
    
}
