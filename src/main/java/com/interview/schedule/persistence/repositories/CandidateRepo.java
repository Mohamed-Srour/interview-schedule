package com.interview.schedule.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.interview.schedule.persistence.entities.Candidate;

public interface CandidateRepo extends JpaRepository<Candidate,Long>{
    @Query(value = "from Candidate c where c.email= :emailId and c.id=:id")
    Candidate findCandidateByEmailId(String email,Long id);   
}
