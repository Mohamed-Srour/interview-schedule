package com.interview.schedule.business.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.schedule.business.dtos.TalentDto;
import com.interview.schedule.business.mappers.TalentMapper;
import com.interview.schedule.business.service.TalentService;
import com.interview.schedule.exceptions.ResourceNotFoundException;
import com.interview.schedule.persistence.entities.Talent;
import com.interview.schedule.persistence.repositories.TalentRepo;

@Service
public class TalentServiceImpl implements TalentService {
    @Autowired
    private TalentRepo talentRepo;

    @Autowired
    private TalentMapper talentMapper;

    @Override
    public TalentDto add(TalentDto talentDto) {
        Talent talent=talentRepo.save(talentMapper.map(talentDto));
        return talentMapper.map(talent);
    }

    @Override
    public List<TalentDto> getAllTalent() throws Exception {
        if(talentRepo.findAll().isEmpty())
        throw new Exception("No Talents found");
        return talentMapper.map(talentRepo.findAll());
    }

    @Override
    public TalentDto getTalent(Long id) {
        Optional<Talent>talent= talentRepo.findById(id);
        talent.orElseThrow(()->new ResourceNotFoundException(id));
        return talentMapper.map(talent.get());
    }
    
}
