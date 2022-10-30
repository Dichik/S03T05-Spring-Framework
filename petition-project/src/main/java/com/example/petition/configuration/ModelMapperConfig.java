package com.example.petition.configuration;

import com.example.petition.entity.VoteEntity;
import com.example.petition.entity.dto.VoteDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ModelMapperConfig {

    @Bean
    @Scope("singleton")
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

        //PropertyMap<VoteEntity, VoteDto> voteMap = new PropertyMap<>() {
        //    protected void configure() {
        //        map().set(source.getAddress().getStreet());
        //        map(source.getAddress().city, destination.city);
        //    }
        //};
        //
        //modelMapper.addMappings(personMap);

        return modelMapper;
    }

}
