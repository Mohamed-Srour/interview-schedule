package com.interview.schedule.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.interview.schedule.persistence.entities.User;

public interface UserRepo extends JpaRepository<User,Long>{
    @Query(value = "from User u where u.emailId= :emailId and u.id=:id")
    User findUserByEmailId(String emailId ,Long id);   
}
