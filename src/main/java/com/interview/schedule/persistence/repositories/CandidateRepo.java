package com.interview.schedule.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.interview.schedule.persistence.entities.Candidate;

public interface CandidateRepo extends JpaRepository<Candidate,Long>{
    
}
