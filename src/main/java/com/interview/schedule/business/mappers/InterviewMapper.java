package com.interview.schedule.business.mappers;

import java.util.Optional;

import org.mapstruct.control.MappingControl.Use;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.schedule.business.dtos.InterviewDto;
import com.interview.schedule.business.service.CandidateService;
import com.interview.schedule.business.service.TalentService;
import com.interview.schedule.business.service.UserService;
import com.interview.schedule.persistence.entities.Candidate;
import com.interview.schedule.persistence.entities.Interview;
import com.interview.schedule.persistence.entities.Talent;
import com.interview.schedule.persistence.entities.User;

@Service
public class InterviewMapper {
    @Autowired
    private UserService userService;
    @Autowired
    private CandidateService candidateService;
    @Autowired
    private TalentService talentService;
    @Autowired
    private TalentMapper talentMapper;

    public InterviewDto toInterviewDto(Interview interview)
    {
        return InterviewDto
                    .builder()
                    .id(interview.getId())
                    .candidateEmailId(Optional.ofNullable(interview.getCandidate()).map(Candidate::getEmail).orElse(null))
                    .interviewerEmailId(Optional.ofNullable(interview.getInterviewer()).map(User::getEmailId).orElse(null))
                    .talentId(Optional.ofNullable(interview.getTalent()).map(Talent::getId).orElse(null))
                    .interviewStatus(interview.getInterviewStatus())
                    .schedulerEmailId(Optional.ofNullable(interview.getSchedular()).map(User::getEmailId).orElse(null))
                    .meetinglink(interview.getMeetingLink())
                    .dateTime(interview.getDateTime())
                    .build();
    }

    public Interview toInterview(InterviewDto interviewDto) throws Exception
    {
        Interview interview=new Interview();
        interview.setCandidate(candidateService.findCandidateByEmailId(interviewDto.getCandidateEmailId(),interviewDto.getId()));
        interview.setSchedular(userService.findUserByEmailId(interviewDto.getSchedulerEmailId(),interviewDto.getId()));
        interview.setInterviewer(userService.findUserByEmailId(interviewDto.getInterviewerEmailId(),interviewDto.getId()));
        interview.setTalent(talentMapper.map(talentService.getTalent(interviewDto.getTalentId())));
        interview.setDateTime(interviewDto.getDateTime());
        interview.setMeetingLink(interviewDto.getMeetinglink());
        interview.setInterviewStatus(interviewDto.getInterviewStatus());
        return interview;
    }
}
