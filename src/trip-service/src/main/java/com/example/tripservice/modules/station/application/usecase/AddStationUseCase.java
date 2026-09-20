package com.example.tripservice.modules.station.application.usecase;

import com.example.tripservice.modules.station.application.dto.request.AddStationCommand;

public interface AddStationUseCase {
    void execute(AddStationCommand command);
}
