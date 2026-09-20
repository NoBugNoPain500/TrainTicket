package com.example.tripservice.modules.city.application.services;

import com.example.tripservice.modules.city.application.dto.response.CityResult;
import com.example.tripservice.modules.city.application.dto.response.GetCitiesResult;
import com.example.tripservice.modules.city.application.usecases.GetCitiesUseCase;
import com.example.tripservice.modules.city.domain.repository.CityRepository;

import java.util.List;

public class GetCitiesService implements GetCitiesUseCase {
    private final CityRepository cityRepository;

    public GetCitiesService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public GetCitiesResult execute() {
        List<CityResult> result =  cityRepository.getAll().stream()
                .map( city ->new CityResult(
                        city.getCityId(),
                        city.getCityName()
                ))
                .toList();
        return new GetCitiesResult(result);
    }
}
