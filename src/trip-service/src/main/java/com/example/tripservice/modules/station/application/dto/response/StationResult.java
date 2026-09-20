package com.example.tripservice.modules.station.application.dto.response;

import com.example.tripservice.modules.station.domain.valueobjects.StationStatus;

public record StationResult(
        Integer stationId,
        String stationName,
        String stationCode,
        Integer cityId,
        String stationAddress,
        StationStatus status
) {
}
