package com.example.tripservice.modules.city.presentation.rest.api;

import com.example.tripservice.modules.city.application.dto.response.GetCitiesResult;
import com.example.tripservice.modules.city.application.usecases.GetCitiesUseCase;
import com.example.tripservice.modules.city.presentation.rest.dto.response.CityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/city")
@RequiredArgsConstructor
public class CityController {
    private final GetCitiesUseCase getCitiesService;

    @GetMapping("/list")
    public ResponseEntity<List<CityResponse>> getCities() {
        GetCitiesResult result = getCitiesService.execute();
        return ResponseEntity.ok(
                result.cities().stream().map(
                        cityResult -> new CityResponse(
                                cityResult.cityId(),
                                cityResult.cityName()
                        )
                ).toList()
        );
    }
}
