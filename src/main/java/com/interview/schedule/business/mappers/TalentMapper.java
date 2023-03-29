package com.interview.schedule.business.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.interview.schedule.business.dtos.TalentDto;
import com.interview.schedule.persistence.entities.Talent;

@Mapper(componentModel = "spring")
public interface TalentMapper {
    
    Talent map(TalentDto talentDto) ;

    TalentDto map(Talent talent);

    List<TalentDto> map(List<Talent> talents);
}
