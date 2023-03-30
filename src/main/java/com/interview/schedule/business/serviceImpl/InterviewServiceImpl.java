package com.interview.schedule.business.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.schedule.business.dtos.EmailDto;
import com.interview.schedule.business.dtos.InterviewDto;
import com.interview.schedule.business.mappers.InterviewMapper;
import com.interview.schedule.business.service.EmailService;
import com.interview.schedule.business.service.InterviewService;
import com.interview.schedule.persistence.entities.Interview;
import com.interview.schedule.persistence.repositories.InterviewRepo;

@Service
public class InterviewServiceImpl implements InterviewService{
    @Autowired
    private InterviewRepo interviewRepo;

    @Autowired
    private InterviewMapper interviewMapper;

    @Autowired
    private EmailService emailService; 

    @Override
    public InterviewDto scheduleItnerview(InterviewDto interviewDto) throws Exception {
        Interview interview=interviewMapper.toInterview(interviewDto);
        interviewRepo.save(interview);
        EmailDto emailDto=composeEmail(interview);
        emailService.sendEmail(emailDto);
        return interviewMapper.toInterviewDto(interview);
    }
    
    private EmailDto composeEmail(Interview interview)
    {
        return EmailDto.builder()
        .from(interview.getSchedular().getEmailId())
        .message(String.format("your interview is scheduled at %s", interview.getDateTime()))
        .subject("interview")
        .toList(getEmails(interview))
        .build();
    }
    private List<String> getEmails(Interview interview)
    {
        List<String> emails=new ArrayList<>();
        emails.add(interview.getCandidate().getEmail());
        emails.add(interview.getSchedular().getEmailId());
        emails.add(interview.getInterviewer().getEmailId());
        return emails;
    }
}
