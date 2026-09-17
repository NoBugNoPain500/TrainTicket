package com.example.movieservice.modules.nation.infrastructure.config;

import com.example.movieservice.modules.nation.application.service.AddNationService;
import com.example.movieservice.modules.nation.application.service.EditNationService;
import com.example.movieservice.modules.nation.application.service.GetNationsService;
import com.example.movieservice.modules.nation.application.usecase.AddNationUseCase;
import com.example.movieservice.modules.nation.application.usecase.EditNationUseCase;
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

    @Bean
    public AddNationUseCase addNationUseCase(NationRepository nationRepository) {
        return new AddNationService(nationRepository);
    }

    @Bean
    public EditNationUseCase editNationUseCase(NationRepository nationRepository) {
        return new EditNationService(nationRepository);
    }
}
