package com.interview.schedule.business.dtos;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto{

    private String message;
    private Integer code;
    private Object data;
}