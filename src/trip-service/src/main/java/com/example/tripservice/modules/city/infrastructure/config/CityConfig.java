package com.example.tripservice.modules.city.infrastructure.config;

import com.example.tripservice.modules.city.application.services.GetCitiesService;
import com.example.tripservice.modules.city.application.usecases.GetCitiesUseCase;
import com.example.tripservice.modules.city.domain.repository.CityRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CityConfig {

    @Bean
    public GetCitiesUseCase getCitiesUseCase(CityRepository cityRepository) {
        return new GetCitiesService(cityRepository);
    }
}
