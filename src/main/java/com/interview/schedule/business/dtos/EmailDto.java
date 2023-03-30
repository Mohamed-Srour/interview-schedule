package com.interview.schedule.business.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@ToString
public class EmailDto {
    
    private String from;
    private String to;
    private List<String> toList;
    private String message;
    private String subject;
}
