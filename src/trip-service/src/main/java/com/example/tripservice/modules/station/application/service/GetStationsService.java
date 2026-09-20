package com.example.tripservice.modules.station.application.service;

import com.example.tripservice.modules.station.application.dto.response.GetStationsResult;
import com.example.tripservice.modules.station.application.dto.response.StationResult;
import com.example.tripservice.modules.station.application.usecase.GetStationsUseCase;
import com.example.tripservice.modules.station.domain.repository.StationRepository;

import java.util.List;

public class GetStationsService implements GetStationsUseCase {

    private final StationRepository stationRepository;

    public GetStationsService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @Override
    public GetStationsResult execute() {
        List<StationResult> stations = stationRepository.getAll().stream()
                .map(
                        station -> new StationResult(
                                station.getStationId(),
                                station.getStationName(),
                                station.getStationCode(),
                                station.getCityId(),
                                station.getStationAddress(),
                                station.getStatus()
                        )
                ).toList();
        return new GetStationsResult(stations);
    }
}
