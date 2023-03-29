package com.interview.schedule.business.service;

import java.util.List;

import com.interview.schedule.business.dtos.CandidateDto;

public interface CandidateService {
    CandidateDto add(CandidateDto candidateDto);

    List<CandidateDto> getAll();

    CandidateDto getUser(Long id);
}
