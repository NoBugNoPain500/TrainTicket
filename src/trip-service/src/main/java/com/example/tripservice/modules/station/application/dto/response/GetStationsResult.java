package com.example.tripservice.modules.station.application.dto.response;

import java.util.List;

public record GetStationsResult(
        List<StationResult> stations
) {}
