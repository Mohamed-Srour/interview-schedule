package com.interview.schedule.business.serviceImpl;

import org.springframework.stereotype.Service;

import com.interview.schedule.business.dtos.EmailDto;
import com.interview.schedule.business.service.EmailService;

@Service
public class GmailServiceImpl implements EmailService{

    @Override
    public void sendEmail(EmailDto emailDto) {
        System.out.println("email sended");
    }
    
}
