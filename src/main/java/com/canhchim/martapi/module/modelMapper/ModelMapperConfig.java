package com.canhchim.martapi.module.modelMapper;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.convention.NameTokenizers;
import org.modelmapper.convention.NamingConventions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
//    @Bean
//    public ModelMapper modelMapper() {
//        ModelMapper modelMapper = new ModelMapper();
//        modelMapper.getConfiguration().setSkipNullEnabled(true);
//        return modelMapper;
//    }
@Bean
public ModelMapper modelMapper() {
    // Tạo object và cấu hình
    ModelMapper modelMapper = new ModelMapper();
    modelMapper.getConfiguration()
            .setMatchingStrategy(MatchingStrategies.STRICT).setSkipNullEnabled(true).setFieldMatchingEnabled(true)
            .setSourceNamingConvention(NamingConventions.NONE)
            .setDestinationNamingConvention(NamingConventions.NONE);

    return modelMapper;
}
}