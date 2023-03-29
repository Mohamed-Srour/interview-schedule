package com.interview.schedule.business.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.interview.schedule.business.dtos.CandidateDto;
import com.interview.schedule.persistence.entities.Candidate;

@Mapper(componentModel = "spring")
public interface CandidateMapper {
    
    CandidateDto map(Candidate candidate);

    Candidate map(CandidateDto candidateDto);

    List<CandidateDto> map(List<Candidate> candidates);
}
