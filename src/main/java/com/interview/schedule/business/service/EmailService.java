package com.interview.schedule.business.service;

import com.interview.schedule.business.dtos.EmailDto;

public interface EmailService {
    void sendEmail(EmailDto emailDto);
}
