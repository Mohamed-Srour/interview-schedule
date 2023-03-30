package com.interview.schedule.business.dtos;

import java.time.LocalDateTime;

import com.interview.schedule.enums.InterviewStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class InterviewDto {
    
    private Long id;
    private String candidateEmailId;
    private String schedulerEmailId;
    private String interviewerEmailId;
    private Long talentId;
    private InterviewStatus interviewStatus;
    private String meetinglink;
    private LocalDateTime dateTime;
}
