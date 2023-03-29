package com.interview.schedule.presentation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.schedule.business.dtos.ResponseDto;
import com.interview.schedule.business.dtos.TalentDto;
import com.interview.schedule.business.service.TalentService;

@RestController
@RequestMapping("/talents")
public class TalentController {
    
    @Autowired
    private TalentService talentService;

    @PostMapping
    public ResponseDto createTalent(@RequestBody TalentDto talentDto)
    {
        return new ResponseDto("Talent added Successfully", 200, talentService.add(talentDto));
    }

    @GetMapping
    public ResponseDto getAllTalents() throws Exception
    {
        return new ResponseDto("All Talents",200,talentService.getAllTalent());
    }

    @GetMapping("/{id}")
    public ResponseDto getTalent(@PathVariable Long id)
    {
        return new ResponseDto("this is the talent with id "+id+"",200,talentService.getTalent(id));
    }
}
