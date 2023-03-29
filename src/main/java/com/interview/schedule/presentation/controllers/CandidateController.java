package com.interview.schedule.presentation.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.schedule.business.dtos.CandidateDto;
import com.interview.schedule.business.dtos.ResponseDto;
import com.interview.schedule.business.service.CandidateService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/candidates")
public class CandidateController {
    
    
   final private CandidateService candidateService;

    @PostMapping
    public ResponseDto addCandidate(@RequestBody CandidateDto candidateDto)
    {
        return new ResponseDto("candidate added successfully",
         200, 
         candidateService.add(candidateDto));
    }

    @GetMapping
    public ResponseDto GetAllCandidates()
    {
        return new ResponseDto(
            "All candidates",
            200,
            candidateService.getAll()
        );
    }

    @GetMapping("/{id}")
    public ResponseDto GetCandidate(@PathVariable Long id){
        return new ResponseDto("this the Candidate with id "+id+"", 200,candidateService.getUser(id));
    
    }
}
