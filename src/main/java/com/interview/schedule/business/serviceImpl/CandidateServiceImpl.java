package com.interview.schedule.business.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.schedule.business.dtos.CandidateDto;
import com.interview.schedule.business.mappers.CandidateMapper;
import com.interview.schedule.business.service.CandidateService;
import com.interview.schedule.exceptions.ResourceNotFoundException;
import com.interview.schedule.persistence.entities.Candidate;
import com.interview.schedule.persistence.repositories.CandidateRepo;

@Service
public class CandidateServiceImpl implements CandidateService{
    @Autowired
    private CandidateRepo candidateRepo;

    @Autowired
    private CandidateMapper candidateMapper;
    @Override
    public CandidateDto add(CandidateDto candidateDto) {
        Candidate candidate=candidateRepo.save(candidateMapper.map(candidateDto));
        return candidateMapper.map(candidate);
    }
    @Override
    public List<CandidateDto> getAll() {
        if(candidateRepo.findAll().isEmpty())
        throw new ResourceNotFoundException(null);
        return candidateMapper.map(candidateRepo.findAll());
    }
    @Override
    public CandidateDto getUser(Long id) {
        Optional<Candidate> candidate=candidateRepo.findById(id);
        candidate.orElseThrow(()->new ResourceNotFoundException(id));
        return candidateMapper.map(candidate.get()); 
    }
    
}
