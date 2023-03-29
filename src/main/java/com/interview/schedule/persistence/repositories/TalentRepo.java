package com.interview.schedule.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.interview.schedule.persistence.entities.Talent;

public interface TalentRepo extends JpaRepository<Talent,Long>{
    
}
