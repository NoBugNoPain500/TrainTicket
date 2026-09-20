package com.example.tripservice.modules.station.application.service;

import com.example.tripservice.modules.station.application.dto.request.EditStationCommand;
import com.example.tripservice.modules.station.application.usecase.EditStationUseCase;
import com.example.tripservice.modules.station.domain.entity.Station;
import com.example.tripservice.modules.station.domain.valueobjects.StationErrorCode;
import com.example.tripservice.modules.station.domain.repository.StationRepository;
import com.example.tripservice.modules.shared.domain.core.dto.ApiException;

public class EditStationService implements EditStationUseCase {

    private final StationRepository stationRepository;

    public EditStationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @Override
    public void execute(EditStationCommand command) {
        Station prev = stationRepository.findById(command.stationId());
        if (prev == null) {
            throw new ApiException(StationErrorCode.STATION_NOT_FOUND);
        }
        if (stationRepository.existsByCodeAndNotId(command.stationCode(), command.stationId())) {
            throw new ApiException(StationErrorCode.DUPLICATE_STATION_CODE);
        }
        if (stationRepository.existsByNameAndNotId(command.stationName(), command.stationId())) {
            throw new ApiException(StationErrorCode.DUPLICATE_STATION_NAME);
        }
        stationRepository.save(
                new Station(
                        command.stationId(),
                        command.stationName(),
                        command.stationCode(),
                        command.cityId(),
                        command.stationAddress(),
                        prev.getStatus()
                )
        );
    }
}
