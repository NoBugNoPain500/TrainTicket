package com.example.tripservice.modules.station.infrastructure.config;

import com.example.tripservice.modules.station.application.service.AddStationService;
import com.example.tripservice.modules.station.application.service.EditStationService;
import com.example.tripservice.modules.station.application.service.GetStationsService;
import com.example.tripservice.modules.station.application.usecase.AddStationUseCase;
import com.example.tripservice.modules.station.application.usecase.EditStationUseCase;
import com.example.tripservice.modules.station.application.usecase.GetStationsUseCase;
import com.example.tripservice.modules.station.domain.repository.StationRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StationApplicationConfig {

    @Bean
    public GetStationsUseCase getStationsUseCase(StationRepository stationRepository) {
        return new GetStationsService(stationRepository);
    }

    @Bean
    public AddStationUseCase addStationUseCase(StationRepository stationRepository) {
        return new AddStationService(stationRepository);
    }

    @Bean
    public EditStationUseCase editStationUseCase(StationRepository stationRepository) {
        return new EditStationService(stationRepository);
    }
}
