package com.example.movieservice.modules.nation.infrastructure.config;

import com.example.movieservice.modules.nation.application.usecase.GetNationsService;
import com.example.movieservice.modules.nation.application.usecase.GetNationsUseCase;
import com.example.movieservice.modules.nation.domain.repository.NationRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NationApplicationConfig {

    @Bean
    public GetNationsUseCase getNationsUseCase(NationRepository nationRepository) {
        return new GetNationsService(nationRepository);
    }
}
