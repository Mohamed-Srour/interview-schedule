package com.interview.schedule.business.service;

import java.util.List;

import com.interview.schedule.business.dtos.CandidateDto;
import com.interview.schedule.persistence.entities.Candidate;

public interface CandidateService {
    CandidateDto add(CandidateDto candidateDto);

    List<CandidateDto> getAll();

    CandidateDto getUser(Long id);

    Candidate findCandidateByEmailId(String Emailid,Long id) throws Exception;
}
