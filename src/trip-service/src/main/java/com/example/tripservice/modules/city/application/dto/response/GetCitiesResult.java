package com.example.tripservice.modules.city.application.dto.response;

import java.util.List;

public record GetCitiesResult(
        List<CityResult> cities
) {
}
