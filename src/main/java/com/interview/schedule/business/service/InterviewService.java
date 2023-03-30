package com.interview.schedule.business.service;

import com.interview.schedule.business.dtos.InterviewDto;

public interface InterviewService {
    InterviewDto scheduleItnerview(InterviewDto interviewDto) throws Exception;
}
