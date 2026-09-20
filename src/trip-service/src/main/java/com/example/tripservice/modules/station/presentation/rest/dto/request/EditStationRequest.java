package com.example.tripservice.modules.station.presentation.rest.dto.request;

public record EditStationRequest(
        int stationId,
        String stationName,
        String stationCode,
        Integer cityId,
        String stationAddress
) {
}
