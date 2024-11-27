package com.inglab.balance_management.config;

import com.inglab.balance_management.dto.request.IncomeAddRequest;
import com.inglab.balance_management.model.Income;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();


        return modelMapper;
    }
}
