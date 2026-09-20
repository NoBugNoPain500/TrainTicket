package com.example.tripservice.modules.station.presentation.rest.dto.response;

import com.example.tripservice.modules.station.domain.valueobjects.StationStatus;

public record StationResponse(
        Integer stationId,
        String stationName,
        String stationCode,
        Integer cityId,
        String stationAddress,
        StationStatus status
) {
}
