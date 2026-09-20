package com.example.tripservice.modules.station.application.usecase;

import com.example.tripservice.modules.station.application.dto.request.EditStationCommand;

public interface EditStationUseCase {
    void execute(EditStationCommand command);
}
