package com.example.tripservice.modules.city.infrastructure.persistence.adapter;

import com.example.tripservice.modules.city.domain.entities.City;
import com.example.tripservice.modules.city.domain.repository.CityRepository;
import com.example.tripservice.modules.city.infrastructure.persistence.mappers.CityMapper;
import com.example.tripservice.modules.city.infrastructure.persistence.repositories.CityJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CityRepositoryAdapter implements CityRepository {

    private final CityJpaRepository cityRepository;
    private final CityMapper mapper;


    @Override
    public List<City> getAll() {
        return cityRepository.getAll()
                .stream()
                .map(
                        mapper::toDomain
                )
                .toList();
    }

    @Override
    public boolean existsByCityName(String cityName) {
        return false;
    }
}
