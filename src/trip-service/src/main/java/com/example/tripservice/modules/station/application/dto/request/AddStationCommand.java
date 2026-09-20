package com.example.tripservice.modules.station.application.dto.request;

public record AddStationCommand(
        String stationName,
        String stationCode,
        Integer cityId,
        String stationAddress
) {
}