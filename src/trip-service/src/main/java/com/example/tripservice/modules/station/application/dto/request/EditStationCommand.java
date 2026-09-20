package com.example.tripservice.modules.station.application.dto.request;

public record EditStationCommand(
        int stationId,
        String stationName,
        String stationCode,
        Integer cityId,
        String stationAddress
) {
}
