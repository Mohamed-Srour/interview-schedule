package com.interview.schedule.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.interview.schedule.persistence.entities.Interview;

public interface InterviewRepo extends JpaRepository<Interview,Long>{
    
}
