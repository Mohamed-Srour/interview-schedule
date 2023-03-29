package com.interview.schedule.business.service;

import java.util.List;

import com.interview.schedule.business.dtos.TalentDto;

public interface TalentService {
    TalentDto add(TalentDto talentDto);

    List<TalentDto> getAllTalent() throws Exception;

    TalentDto getTalent(Long id);
}
