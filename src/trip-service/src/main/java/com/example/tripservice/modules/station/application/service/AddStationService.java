package com.example.tripservice.modules.station.application.service;

import com.example.tripservice.modules.station.application.dto.request.AddStationCommand;
import com.example.tripservice.modules.station.application.usecase.AddStationUseCase;
import com.example.tripservice.modules.station.domain.entity.Station;
import com.example.tripservice.modules.station.domain.valueobjects.StationErrorCode;
import com.example.tripservice.modules.station.domain.repository.StationRepository;
import com.example.tripservice.modules.shared.domain.core.dto.ApiException;
import com.example.tripservice.modules.station.domain.valueobjects.StationStatus;

public class AddStationService implements AddStationUseCase {

    private final StationRepository stationRepository;

    public AddStationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @Override
    public void execute(AddStationCommand command) {
        if (stationRepository.existsByCode(command.stationCode())) {
            throw new ApiException(StationErrorCode.DUPLICATE_STATION_CODE);
        }
        if (stationRepository.existsByName(command.stationName())) {
            throw new ApiException(StationErrorCode.DUPLICATE_STATION_NAME);
        }
        stationRepository.save(
                new Station(
                        null,
                        command.stationName(),
                        command.stationCode(),
                        command.cityId(),
                        command.stationAddress(),
                        StationStatus.ACTIVE
                )
        );
    }
}
