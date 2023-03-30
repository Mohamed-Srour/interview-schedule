package com.interview.schedule.presentation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.schedule.business.dtos.InterviewDto;
import com.interview.schedule.business.dtos.ResponseDto;
import com.interview.schedule.business.service.InterviewService;

@RestController
@RequestMapping("/interviews")
public class InterviewController {
    
    @Autowired
    private InterviewService interviewService;

    @PostMapping
    public ResponseDto scheduleItnerview(@RequestBody InterviewDto interviewDto) throws Exception
    {
        return new ResponseDto("Interview scheduled successfully",200,interviewService.scheduleItnerview(interviewDto));
    }

}
