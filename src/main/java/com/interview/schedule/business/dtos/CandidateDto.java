package com.interview.schedule.business.dtos;

import lombok.Data;

@Data
public class CandidateDto {
    
    private Long id;
    private String name;
    private String address;
    private String email;
    private String mobile;
    private Integer ctc;
    private Integer ectc;
    private String Location;
    private String notice;
    private String resumeUrl;
}
